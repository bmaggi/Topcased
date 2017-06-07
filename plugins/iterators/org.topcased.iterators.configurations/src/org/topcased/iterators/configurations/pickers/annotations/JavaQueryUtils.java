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
package org.topcased.iterators.configurations.pickers.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JavaQueryUtils {

	public static Map<String, ArgumentDescriptor> getArguments(IJavaQuery query, Object element) {
		Map<String, ArgumentDescriptor> result = new HashMap<String, ArgumentDescriptor>();
		if(query != null) {
			Class<?> type = query.getClass();
			for(Field t : getAllFields(type)) {
				if(t.isAnnotationPresent(Argument.class)) {
					Argument arg = t.getAnnotation(Argument.class);
					ArgumentDescriptor desc = new ArgumentDescriptor();
					desc.type = t.getType();
					String description = arg.description();
					if(description != null && description.length() > 0) {
						desc.description = description;
					} else {
						desc.description = t.getName();
					}
					// if boolean
					if(desc.type.equals(boolean.class)) {
						desc.choices = new String[]{ "true", "false" };
					} else {
						// if a getChoices() method is provided
						Method choicesMethod = null;
						for(Method m : type.getDeclaredMethods()) {
							if(m.isAnnotationPresent(Choices.class)) {
								Choices choicesAnnotation = m.getAnnotation(Choices.class);
								if(choicesAnnotation.argumentName().equals(t.getName())) {
									choicesMethod = m;
									break;
								}
							}
						}
						if(choicesMethod != null && element != null) {
							try {
								boolean flag = false;
								if(!choicesMethod.isAccessible()) {
									choicesMethod.setAccessible(true);
									flag = true;
								}
								desc.choices = (String[])choicesMethod.invoke(query, element);
								if(flag) {
									choicesMethod.setAccessible(false);
								}
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							desc.choices = arg.choices();
						}
					}
					result.put(t.getName(), desc);
				}
			}
		}
		return result;
	}

	private static Field[] getAllFields(Class<?> type) {
		List<Field> allFields = new LinkedList<Field>();
		while(type != null) {
			allFields.addAll(Arrays.asList(type.getDeclaredFields()));
			type = type.getSuperclass();
		}
		return allFields.toArray(new Field[allFields.size()]);
	}

	public static void setValues(Map<String, Object> arguments, IJavaQuery query) {
		if(query != null) {
			Class<?> type = query.getClass();
			// check all attributes from supertypes
			while(type != Object.class) {

				for(Field field : type.getDeclaredFields()) {

					if(field.isAnnotationPresent(Argument.class)) {
						boolean flag = false;
						if(!field.isAccessible()) {
							field.setAccessible(true);
							flag = true;
						}
						try {
							field.set(query, arguments.get(field.getName()));
						} catch (IllegalArgumentException e) {
						} catch (IllegalAccessException e) {
						}
						if(flag) {
							field.setAccessible(false);
						}
					}
				}
				type = type.getSuperclass();

			}
		}
	}

	public static Map<String, Object> getValues(IJavaQuery query) {
		Map<String, Object> values = new HashMap<String, Object>();
		if(query != null) {
			Class<?> type = query.getClass();
			// check all attributes from supertypes
			while(type != Object.class) {

				for(Field field : type.getDeclaredFields()) {

					if(field.isAnnotationPresent(Argument.class)) {
						boolean flag = false;
						if(!field.isAccessible()) {
							field.setAccessible(true);
							flag = true;
						}
						Object value;
						try {
							value = field.get(query);
							values.put(field.getName(), value);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						if(flag) {
							field.setAccessible(false);
						}
					}
				}
				type = type.getSuperclass();

			}
		}
		return values;
	}

	public static class ArgumentDescriptor {

		public Class<?> type = null;

		public String description = null;

		public String[] choices = null;
	}

}
