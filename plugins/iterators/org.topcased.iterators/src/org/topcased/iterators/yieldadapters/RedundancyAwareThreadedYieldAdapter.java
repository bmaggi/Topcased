/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos - initial API and implementation
 ******************************************************************************/
package org.topcased.iterators.yieldadapters;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

import org.topcased.iterators.collectors.Collector;
import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.exceptions.RedundancyException;
import org.topcased.iterators.handlers.ResultHandler;
import org.topcased.iterators.utils.YieldAdapterIterable;
import org.topcased.iterators.utils.YieldAdapterIterator;

/**
 * A class to convert methods that implement the Collector<> class into a standard Iterable<>, using
 * a new thread created for the collection process, and a SynchronousQueue<> object.
 */
public class RedundancyAwareThreadedYieldAdapter<T> implements YieldAdapter<T> {

	/**
	 * Message structure to pass values between threads.
	 */
	class Message {

	}

	abstract private class StopMessage extends Message {

	}

	private class EndMessage extends StopMessage {

	}

	private class AbortedMessage extends StopMessage {

	}

	/**
	 * The vehicle to pass the actual values.
	 */
	class ValueMessage extends Message {

		ValueMessage(T value) {
			this.value = value;
		}

		final T value;
	}

	/**
	 * Convert a method that implements the Collector<> class with a standard Iterable<>. This means
	 * that the collecting method can use complex recursive logic, but still allows the calling code
	 * to handle the results with a standard iterator. Results are returned immediately and do not
	 * incur overhead of being stored in a list. Calculation overhead is only performed for the
	 * results that are requested through the iterator.
	 * 
	 * This is implemented using a new thread created for the collection process, and a
	 * SynchronousQueue<> object.
	 */
	public YieldAdapterIterable<T> adapt(final Collector<T> client) {

		return new YieldAdapterIterable<T>() {

			public YieldAdapterIterator<T> iterator() {

				final SynchronousQueue<Message> synchronousQueue = new SynchronousQueue<Message>();

				// Mechanism to ensure both threads don't run at the same time
				final SynchronousQueue<Object> returnQueue = new SynchronousQueue<Object>();

				// This thread is where the collecting logic is executed.
				final Thread collectThread = new Thread() {

					@Override
					public void run() {

						// Important .. handling thread (main thread) gets to run first.
						// This is because the collecting process should be run on demand in response to
						// iterator access. Each result should be dealt with by the handling process before
						// the collecting process is able to modify any resources that may be requred by
						// results.

						try {
							returnQueue.take();
						} catch (InterruptedException e) {
							throw new RuntimeException("Error with yield adapter", e);
						}
						try {
							try {

								/*
								 * This set allows the adapter to be redundancy-aware.
								 */
								final Set<T> results = new LinkedHashSet<T>();

								client.collect(new ResultHandler<T>() {

									public void handleResult(T value) throws CollectionAbortedException, RedundancyException {
										if(results.contains(value)) {
											throw new RedundancyException(value);
										}
										try {
											synchronousQueue.put(new ValueMessage(value));
											results.add(value);
											returnQueue.take(); // wait for permission to continue
										} catch (InterruptedException e) {
											// this thread has been aborted
											throw new CollectionAbortedException(e);
										}
									}
								});

								synchronousQueue.put(new EndMessage());
								// Signal no more results to come

							} catch (CollectionAbortedException collectionAborted) {
								if(!(collectionAborted.getCause() instanceof InterruptedException)) {
									// Collect was aborted by client
									// This is not sent on thread abort as there is nothing waiting
									// to receive it, and the thread will block.
									synchronousQueue.put(new AbortedMessage());
								}
							}

						} catch (InterruptedException e) {
							// Operation was aborted internally (e.g.  iterator out of scope)
						}
					}
				};
				collectThread.start();

				return new YieldAdapterIterator<T>() {

					private Message messageWaiting = null;

					public boolean hasNext() {

						readNextMessage();
						return !StopMessage.class.isAssignableFrom(messageWaiting.getClass());
						// instanceof cannot be used because of generics restriction
					}

					public T next() {
						readNextMessage();

						if(StopMessage.class.isAssignableFrom(messageWaiting.getClass())) {
							// instanceof cannot be used because of generics restriction
							throw new NoSuchElementException();
						}

						@SuppressWarnings("unchecked")
						final T value = ((ValueMessage)messageWaiting).value;
						messageWaiting = null; // for next time
						return value;
					}

					private void readNextMessage() {
						if(messageWaiting == null) { // do not run if value waiting to be put
							try {
								returnQueue.put(new Object()); // allow other thread to gather result
								messageWaiting = synchronousQueue.take();

							} catch (InterruptedException e) {
								messageWaiting = new EndMessage();
							}
						}
					}

					public void remove() {
					}

					@Override
					/**
					 * Iterator's finalize() can be used to tell when it is out of scope, and the
					 * collecting thread can be terminated.
					 */
					protected void finalize() throws Throwable {
						dispose();
						super.finalize();
					}

					/**
					 * This can be manually called by the calling code to force release of
					 * resources at the earliest opportunity.
					 */
					public void dispose() {
						collectThread.interrupt();
					}
				};
			}
		};
	}
}
