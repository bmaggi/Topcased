//------------------------------------------------
// $Id: WizardsUtil.java,v 1.3 2006/12/18 14:47:50 jako Exp $
// (c) Anyware Technologies 2006    www.anyware-tech.com
//------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.topcased.facilities.widgets.SingleObjectChooser;

/**
 * 
 * Creates composite used in wizards <br>
 * creation : 6 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class WizardsUtil
{

    /**
     * Returns a composite made with a label and an SingleObjectComboChooser using the given labelProvider to display
     * label
     * 
     * @param parent
     * @param label
     * @param labelProvider
     * @return the SingleObjectChooser
     */
    public static SingleObjectChooser createSingleObject(Composite parent, String label, IBaseLabelProvider labelProvider)
    {
        // Container Ref
        Label containerRefLabel = new Label(parent, SWT.CENTER);
        containerRefLabel.setText(label);

        // Source Combo
        GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
        SingleObjectChooser chooser = new SingleObjectChooser(parent, SWT.NULL);
        if (labelProvider != null)
        {
            chooser.setLabelProvider(labelProvider);
        }
        chooser.setLayoutData(layoutData);

        return chooser;
    }
}