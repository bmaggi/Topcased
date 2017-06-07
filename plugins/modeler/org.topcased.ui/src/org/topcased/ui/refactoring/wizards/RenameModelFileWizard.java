/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.refactoring.wizards;

import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.topcased.core.refactoring.RenameModelFileInfo;
import org.topcased.core.refactoring.RenameModelFileRefactoring;

/**
 * <p>
 * The wizard that is shown to the user for entering the necessary information for model/diagram file(s) renaming.
 * </p>
 * 
 * <p>
 * The wizard class is primarily needed for deciding which pages are shown to the user. The actual user interface
 * creation goes on the pages.
 * </p>
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileWizard extends RefactoringWizard
{

    private final RenameModelFileInfo info;

    /**
     * The Constructor
     * 
     * @param refactoring
     * @param info an Object that contains informations about the refactoring
     */
    public RenameModelFileWizard(final RenameModelFileRefactoring refactoring, final RenameModelFileInfo info)
    {
        super(refactoring, DIALOG_BASED_USER_INTERFACE);
        this.info = info;
    }

    /**
     * @see org.eclipse.ltk.ui.refactoring.RefactoringWizard#addUserInputPages()
     */
    @Override
    protected void addUserInputPages()
    {
        setDefaultPageTitle(getRefactoring().getName());
        addPage(new RenameModelFileInputPage(info));
    }
}
