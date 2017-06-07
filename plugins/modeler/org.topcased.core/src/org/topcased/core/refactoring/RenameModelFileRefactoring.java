/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.core.refactoring;

import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

/**
 * <p>
 * Refactoring for renaming Diagram/Model file in a Topcased Project.
 * </p>
 * 
 * <p>
 * All the actual work is done in the processor, so we just have to keep a reference to one here.
 * <p>
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileRefactoring extends ProcessorBasedRefactoring
{

    private final RefactoringProcessor processor;

    /**
     * The constructor
     * 
     * @param processor a RefactoringProcessor
     */
    public RenameModelFileRefactoring(final RefactoringProcessor processor)
    {
        super(processor);
        this.processor = processor;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring#getProcessor()
     */
    public RefactoringProcessor getProcessor()
    {
        return processor;
    }
}
