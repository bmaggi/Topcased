/*******************************************************************************
* Copyright (c) 2005 AIRBUS FRANCE.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
*    Jacques Lescot (Anyware Technologies) - initial API and implementation
*******************************************************************************/ 
package org.topcased.modeler.configurator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.CompoundCommand#getSubCommands <em>Sub Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getCompoundCommand()
 * @model
 * @generated
 */
public interface CompoundCommand extends PaletteCommand
{
    /**
     * Returns the value of the '<em><b>Sub Commands</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.PaletteCommand}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Commands</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Commands</em>' reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getCompoundCommand_SubCommands()
     * @model type="org.topcased.modeler.configurator.PaletteCommand"
     * @generated
     */
    EList getSubCommands();

} // CompoundCommand
