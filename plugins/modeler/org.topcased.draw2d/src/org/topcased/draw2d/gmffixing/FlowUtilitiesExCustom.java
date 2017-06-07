package org.topcased.draw2d.gmffixing;

import org.eclipse.draw2d.TextUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.text.FlowUtilitiesEx;

/**
 * This class extends GEF's <code>FlowUtilities</code> class to provide
 * mapmode support.
 * This class is a hack because of the no compatibility between topcased and
 * gmf runtime 1.1.3
 * This class extends FlowUtilitiesEx and override methods to returns custom elements
 * @since 2.5
 * @TODO for > 2.5 check compatibility with gmf runtime
 * @FIXME 
 * @author satif, crevells, tfaure
 */
public class FlowUtilitiesExCustom
    extends FlowUtilitiesEx {

    /**
     * The mapmode to be used for translating measurement units.
     */
    private IMapMode mapmode;

    private TextUtilities textUtilities;

    /**
     * Creates a new instance.
     * 
     * @param mapmode
     *            mapmode to be used for translating measurement units
     */
    public FlowUtilitiesExCustom(IMapMode mapmode) {
        super(mapmode);
        this.mapmode = mapmode;
    }

    @Override
    protected TextUtilities getTextUtilities()
    {
        if (textUtilities == null)
        {
            textUtilities = new TextUtilitiesExCustom(mapmode);
        }
        return textUtilities;
    }

}
