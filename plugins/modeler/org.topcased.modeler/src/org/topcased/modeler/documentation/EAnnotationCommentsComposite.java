/***********************************************************************
 * Copyright (c) 2005, 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation 
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thomas Friol (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - feature #1414
 *    Tristan FAURE (ATOS ORIGIN INTEGRATION) - label for type information
 **********************************************************************/
package org.topcased.modeler.documentation;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.commands.ChangeDocumentationCommand;

/**
 * A class defining a composite to edit the comments of a EModelElement through an EAnnotation.<br>
 * <br>
 * Created : 10 Oct. 2005<br>
 * Updated : 4 Dec. 2008<br>
 * Updated : 11 Aug. 2009 (Completely refactor that class into an abstract class {@link AbstractCommentsComposite} and a
 * default implementation one<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EAnnotationCommentsComposite extends AbstractCommentsComposite
{
    private Text infoText;

    private static String typeLabel = "Documentation for current ";

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param commandStack the command stack to use to execute commands
     * @deprecated use {@link #EAnnotationCommentsComposite(Composite, int, IEditingDomainProvider)} instead
     */
    public EAnnotationCommentsComposite(Composite parent, int style, CommandStack commandStack)
    {
        super(parent, style, commandStack);
    }

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param editingDomainProvider the provider of editing domain to execute commands
     */
    public EAnnotationCommentsComposite(Composite parent, int style, IEditingDomainProvider editingDomainProvider)
    {
        super(parent, style, editingDomainProvider);
    }

    @Override
    protected void createContents(Composite parent)
    {
        boolean labelForTypeInformation = (getStyle() & EAnnotationDocPage.STYLE_TEXT_TYPE) != 0;
        if (labelForTypeInformation)
        {
            infoText = new Text(parent, SWT.READ_ONLY);
        }
        super.createContents(parent);
        if (infoText != null)
        {
            infoText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }
    }

    /**
     * That generic implementation will store the documentation in an EAnnotation, as we supposed the selected element
     * is an EModelElement.
     */
    @Override
    protected String getDocumentationValueFromElement()
    {
        String docValue = "";
        // Check whether the element is an EModelElement
        if (getDocumentedElement() instanceof EModelElement)
        {
            EAnnotation annotation = ((EModelElement) getDocumentedElement()).getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
            if (annotation != null)
            {
                docValue = annotation.getDetails().get(IAnnotationConstants.DOCUMENTATION_KEY);
            }
        }
        return docValue == null ? "" : docValue;
    }

    /**
     * @see org.topcased.modeler.documentation.AbstractCommentsComposite#handleDocChanged()
     */
    @Override
    public void handleDocChanged()
    {
        if (getDocumentedElement() != null && getDocumentedElement() instanceof EModelElement)
        {
            getCommandStack().execute(
                    new ChangeDocumentationCommand((EModelElement) getDocumentedElement(), getUseRichTextEditorButton().getSelection() ? getRichTextComposite().getDocumentationValue()
                            : getPlainTextComposite().getDocumentationValue()));
        }
    }

    @Override
    public void setDocumentedElement(EObject modelElement)
    {
        super.setDocumentedElement(modelElement);
        if (modelElement != null && infoText != null)
        {
            infoText.setText(typeLabel + modelElement.eClass().getName());
        }
    }

}
