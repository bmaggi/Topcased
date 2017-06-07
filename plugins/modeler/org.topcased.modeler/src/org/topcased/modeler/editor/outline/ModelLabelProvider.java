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
package org.topcased.modeler.editor.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.ColorRegistry;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * This Label Provider displays informations about model and diagrams. For the model, this provider delegates
 * informations computing to the model label provider. <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class ModelLabelProvider extends LabelProvider implements IFontProvider, IColorProvider
{
    private Font boldFont = null;

    private Font italicFont = null;

    private Font italicBoldFont = null;

    /** The delegated model label provider */
    private ILabelProvider delegatedModelProvider;

    private EditingDomain editingDomain;

    /**
     * Constructor
     * 
     * @param delegatedProvider the delegated label provider of the model
     */
    public ModelLabelProvider(ILabelProvider delegatedProvider)
    {
        this(delegatedProvider, null);
    }

    /**
     * Constructor
     * 
     * @param delegatedProvider the delegated label provider of the model
     * @param domain the optional editing domain, used to detect read-only elements
     */
    public ModelLabelProvider(ILabelProvider delegatedProvider, EditingDomain domain)
    {
        delegatedModelProvider = delegatedProvider;
        editingDomain = domain;
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    public Image getImage(Object element)
    {
        if (element instanceof Diagram)
        {
            Diagram diag = (Diagram) element;

            return getDiagramIcon(diag);
        }
        // a virtual container instance can define image
        if (element instanceof VirtualContainerInstance)
        {
            Image image = ((VirtualContainerInstance) element).getImage();
            if (image != null)
            {
                return image;
            }
        }
        return delegatedModelProvider.getImage(element);
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element)
    {
        if (element instanceof AdditionalResources)
        {
            return "Additional Resources";
        }
        if (element instanceof Diagram)
        {
            Diagram diag = (Diagram) element;

            return getDiagramText(diag);
        }
        if (element instanceof VirtualContainerInstance)
        {
            return ((VirtualContainerInstance) element).getLabel();
        }
        if (element instanceof Resource)
        {
            // decode URI before displaying it (avoid to have encoding characters)
            return URI.decode(((Resource) element).getURI().toString());
        }

        return delegatedModelProvider.getText(element);
    }

    /**
     * Compose the diagram label
     * 
     * @param d the diagram
     * @return the diagram label
     */
    private String getDiagramText(Diagram d)
    {
        String name = d.getName();
        String id = d.getSemanticModel().getPresentation();
        String diagramTypeName = "Diagram";
        if (id != null && !"".equals(id))
        {
            DiagramDescriptor diagDesc = DiagramsManager.getInstance().find(id);
            if (diagDesc != null)
            {
                diagramTypeName = diagDesc.getName();
            }
        }

        return name == null || name.length() == 0 ? diagramTypeName : diagramTypeName + " " + name;
    }

    /**
     * Get the diagram icon
     * 
     * @param d the diagram
     * @return the diagram label
     */
    private Image getDiagramIcon(Diagram d)
    {
        String id = d.getSemanticModel().getPresentation();
        if (id != null && !"".equals(id))
        {
            DiagramDescriptor diagDesc = DiagramsManager.getInstance().find(id);
            if (diagDesc != null)
            {
                Image icon = diagDesc.getIcon();
                if (icon != null)
                {
                    return icon;
                }
            }
        }

        return delegatedModelProvider.getImage(d);
    }

    /**
     * Get the specific font to display an element. Font is italic for a read-only element and/or bold for a diagram
     * 
     * @return specific font or null if normal font
     * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
     */
    public Font getFont(Object element)
    {
        if (element instanceof Diagram && isReadOnly((EObject) element))
        {
            if (italicBoldFont == null)
            {
                italicBoldFont = getStyledFont(Display.getCurrent().getSystemFont(), SWT.BOLD | SWT.ITALIC);
            }
            return italicBoldFont;
        }
        else if (element instanceof Diagram)
        {
            if (boldFont == null)
            {
                boldFont = getStyledFont(Display.getCurrent().getSystemFont(), SWT.BOLD);
            }
            return boldFont;
        }
        else if (element instanceof EObject && isReadOnly((EObject) element))
        {
            if (italicFont == null)
            {
                italicFont = getStyledFont(Display.getCurrent().getSystemFont(), SWT.ITALIC);
            }
            return italicFont;
        }
        return null;
    }

    private Font getStyledFont(Font originalFont, int style)
    {
        FontData[] fontData = originalFont.getFontData();
        for (int i = 0; i < fontData.length; i++)
        {
            fontData[i].setStyle(fontData[i].getStyle() | style);
        }
        return new Font(Display.getDefault(), fontData);
    }

    private boolean isReadOnly(EObject obj)
    {
        return editingDomain != null && editingDomain.isReadOnly(obj.eResource());
    }

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#dispose()
     */
    public void dispose()
    {
        super.dispose();
        if (boldFont != null)
        {
            boldFont.dispose();
        }
        if (italicFont != null)
        {
            italicFont.dispose();
        }
        if (italicBoldFont != null)
        {
            italicBoldFont.dispose();
        }
    }

    public Color getBackground(Object element)
    {
        return null;
    }

    public Color getForeground(Object element)
    {
        if (element instanceof EObject)
        {
            EObject eobject = (EObject) element;
            if (isInOpenedResource(eobject))
            {
                // if a preference is set to define different colors for resources
                if (isUseDifferentColors())
                {
                    return ColorRegistry.getColor(PreferenceConverter.getColor(Utils.getPreferenceStoreAccordingToCurrentIFile(), ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_DIFFERENT_RESOURCE));
                }
            }
        }
        return ColorRegistry.getColor(PreferenceConverter.getColor(Utils.getPreferenceStoreAccordingToCurrentIFile(), ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_SAME_RESOURCE));
    }

    private boolean isUseDifferentColors()
    {
        return Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL);
    }

    /**
     * Check if element is not directly contained by the main opened resource, but is in dependent resources.
     * 
     * @param element element to check
     * @return true if element is not directly contained by the main resource, but in a child resource
     */
    private boolean isInOpenedResource(EObject element)
    {
        if (element == null)
        {
            return false;
        }
        if (editingDomain instanceof AdapterFactoryEditingDomain)
        {
            EditingDomainHelper helper = EditingDomainHelper.getInstance((AdapterFactoryEditingDomain) editingDomain);
            return helper.isInOpenedResource(element);
        }
        return false;
    }
}
