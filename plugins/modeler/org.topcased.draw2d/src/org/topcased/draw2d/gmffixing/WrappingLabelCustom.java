/******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.topcased.draw2d.gmffixing;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.text.FlowContext;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.internal.mapmode.IMapModeHolder;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.draw2d.ui.text.TruncatedSingleLineTextLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

/**
 * An extended label that has the following extra features: <br>
 * 1. Allows selection, focus feedback, underlined and striked-through text.<br>
 * 2. Enhanced layout functionality for placing icon and text.<br>
 * 3. Text will be word-wrapped to fit the text in the width available.<br>
 * 4. Text will be truncated with an ellipsis if the entire text does not fit in the space available.<br>
 * <p>
 * <b>EXPLANATION OF LAYOUTS</b><br>
 * 
 * This WrappingLabel contains functionality to display an icon alongside text. The following will describe how the
 * layout of the icon and text are done.
 * <p>
 * <br>
 * 
 * 
 * <u>Using {@link #setTextPlacement(int)}:</u>
 * <p>
 * 
 * The position of the text <i>relative</i> to the icon depends on {@link #setTextPlacement(int)}. If the text placement
 * is set to {@link PositionConstants#EAST}, then the text would be placed on the right of the icon. Similarly, if text
 * placement is set to {@link PositionConstants#WEST}, the text will be placed on the left of the icon;
 * {@link PositionConstants#NORTH} would put the text above the icon; and {@link PositionConstants#SOUTH} would place
 * the text below the icon.
 * <p>
 * <br>
 * 
 * <u>Using {@link #setTextAlignment(int)} and {@link #setIconAlignment(int)}:</u>
 * <p>
 * 
 * Use {@link #setTextAlignment(int)} and {@link #setIconAlignment(int)} to align the text and icons <i>relative</i> to
 * each other for more dynamic control. If the text placement is on the east or west of the icon(s) (i.e. the text on
 * the right or left of the icon respectively), then only {@link PositionConstants#TOP},
 * {@link PositionConstants#CENTER}, and {@link PositionConstants#BOTTOM} can be used when calling
 * {@link #setTextAlignment(int)} and {@link #setIconAlignment(int)}. In this case, setting the text alignment to
 * {@link PositionConstants#TOP} will make sure that the top of the text is aligned horizontally with the top of the
 * icon <i>if</i> the height of the icon is greater than the height of the text. Similarly, setting the text alignment
 * to {@link PositionConstants#CENTER} will make sure that the top of the text is aligned horizontally with the vertical
 * center of the size of icon <i>if</i> the height of the icon is greater than the height of the text. Also, setting the
 * text alignment to {@link PositionConstants#BOTTOM} will make sure that the bottom of the text is aligned horizontally
 * with the bottom of the icon <i>if</i> the height of the icon is greater than the height of the text.
 * <p>
 * 
 * The other scenario is when the text placement is on the south or north of the icon (i.e. the text is below or above
 * the icon respectively). If this is true, only {@link PositionConstants#LEFT}, {@link PositionConstants#CENTER}, and
 * {@link PositionConstants#RIGHT} can be used when calling {@link #setTextAlignment(int)} and
 * {@link #setIconAlignment(int)}. In this case, setting the text alignment to {@link PositionConstants#LEFT} will make
 * sure that the left of the text is aligned vertically with the left of the icon <i>if</i> the width of the icon is
 * greater than the width of the text. Similarly, setting the text alignment to {@link PositionConstants#CENTER} will
 * make sure that the left of the text is aligned vertically with the horizontal center of the icon <i>if</i> the width
 * of the icon is greater than the width of the text. Also, setting the text alignment to
 * {@link PositionConstants#RIGHT} will make sure that the right of the text is aligned vertically with the right of the
 * icon <i>if</i> the width of the icon is greater than the width of the text.
 * <p>
 * 
 * {@link #setIconAlignment(int)} works identically as {@link #setTextAlignment(int)}, except the roles of text and icon
 * are switched in the above descriptions.
 * <p>
 * <br>
 * 
 * 
 * <u>Using {@link #setAlignment(int)}:</u>
 * <p>
 * 
 * The entire label, text and icon, can be moved into different positions with the label figure, if the figure is bigger
 * than the icon and text. The alignment of the label places the text and icon (no matter how they are arranged
 * relatively to each other) in the top-left, top, top-right, left, center, right, bottom-left, bottom, or bottom-right
 * of the bounds of this <code>WrappingLabel</code> figure.
 * <p>
 * <br>
 * 
 * 
 * <u>Using {@link #setTextHorizontalAlignment(int)}:</u>
 * <p>
 * 
 * Use {@link #setTextJustification(int)} with {@link PositionConstants#LEFT}, {@link PositionConstants#CENTER}, or
 * {@link PositionConstants#RIGHT} to justify the text when wordwrap is turned on. The effect will be noticed in
 * multi-lined text only.
 * <p>
 * <br>
 * 
 * WARNING: User-nested figures are not expected within this figure.
 * <p>
 * 
 * Some code taken from the original <code>WrapLabel</code> in GMF by melaasar.
 * <p>
 * 
 * This class is a hack to resolve compatibility problems with gmf runtime 1.1.3
 * we are sorry to use java.lang.reflect into code but we don't have the possibility 
 * to modify differently
 * 
 * @since 2.5
 * @TODO for > 2.5 check compatibility with gmf runtime
 * @FIXME 
 * @author satif, crevells
 */
@SuppressWarnings("restriction")
public class WrappingLabelCustom extends WrappingLabel implements PositionConstants
{
    private static final Dimension EMPTY_DIMENSION = new Dimension(0, 0);
    
    static final String ELLIPSIS = "..."; //$NON-NLS-1$
    
    private static final Map<IMapMode, MapModeConstants> mapModeConstantsMap = new WeakHashMap<IMapMode, MapModeConstants>();
    
    private MapModeConstants mapModeConstants;
    
    static class MapModeConstants
    {
        private static final int MAX_IMAGE_INFO = 12;

        public final WeakReference<IMapMode> mapModeRef;

        public final int nDPtoLP_3;

        public final int nDPtoLP_2;

        public final int nDPtoLP_0;

        public final Dimension dimension_nDPtoLP_0;

        public final WeakHashMap<Font, Dimension> fontToEllipseTextSize = new WeakHashMap<Font, Dimension>();

        public final SingleIconInfo[] singleIconInfos = new SingleIconInfo[MAX_IMAGE_INFO];

        public MapModeConstants(IMapMode mapMode)
        {
            this.mapModeRef = new WeakReference<IMapMode>(mapMode);
            nDPtoLP_2 = mapMode.DPtoLP(2);
            nDPtoLP_3 = mapMode.DPtoLP(3);
            nDPtoLP_0 = mapMode.DPtoLP(0);
            dimension_nDPtoLP_0 = new Dimension(nDPtoLP_0, nDPtoLP_0);
        }

        public Dimension getEllipseTextSize(Font f)
        {
            Dimension d = fontToEllipseTextSize.get(f);
            if (d == null)
            {
                IMapMode mapMode = mapModeRef.get();
                d = FigureUtilities.getTextExtents(ELLIPSIS, f);
                d.height = FigureUtilities.getFontMetrics(f).getHeight();
                d = new Dimension(mapMode.DPtoLP(d.width), mapMode.DPtoLP(d.height));
                fontToEllipseTextSize.put(f, d);
            }
            return d;
        }

        public SingleIconInfo getSingleIconInfo(Image image)
        {
            if (image == null)
            {
                return SingleIconInfo.NULL_INFO;
            }
            SingleIconInfo info;
            for (int i = 0; i < MAX_IMAGE_INFO; ++i)
            {
                info = singleIconInfos[i];
                if (info == null)
                {
                    info = new SingleIconInfo(image);
                    singleIconInfos[i] = info;
                    return info;
                }
                if (info.icon == image)
                {
                    return info;
                }
            }
            int index = SingleIconInfo.count % MAX_IMAGE_INFO;
            info = new SingleIconInfo(image);
            singleIconInfos[index] = info;
            return info;
        }
    }
    private static abstract class IconInfo
    {

        /**
         * Gets the icon at the index location.
         * 
         * @param i the index to retrieve the icon of
         * @return <code>Image</code> that corresponds to the given index.
         */
        public abstract Image getIcon(int i);

        /**
         * Gets the icon size of the icon at the given index.
         * 
         * @param i
         * @return the <code>Dimension</code> that is the size of the icon at the given index.
         */
        public abstract Dimension getIconSize(IMapMode mapMode, int i);

        /**
         * @return the number of icons
         */
        public abstract int getNumberofIcons();

        /**
         * @return the <code>Dimension</code> that is the total size of all the icons.
         */
        public abstract Dimension getTotalIconSize(IMapMode mapMode);

        public abstract void invalidate();

        /**
         * Sets the icon at the index location.
         * 
         * @param icon
         * @param i
         */
        public abstract void setIcon(Image icon, int i);

        /**
         * 
         */
        public abstract int getMaxIcons();

    }
    private static class SingleIconInfo extends IconInfo
    {

        static int count;

        public static final SingleIconInfo NULL_INFO = new SingleIconInfo()
        {

            public int getNumberofIcons()
            {
                return 0;
            }
        };

        final Image icon;

        /** total icon size */
        private Dimension totalIconSize;

        private SingleIconInfo()
        {
            icon = null;// don't increment count, used only for NULL_INFO
        }

        public SingleIconInfo(Image icon)
        {
            this.icon = icon;
            ++count;
        }

        public final int getMaxIcons()
        {
            return 1;
        }

        public Image getIcon(int i)
        {
            if (i == 0)
            {
                return icon;
            }
            else if (i > 0)
            {
                return null;
            }
            throw new IndexOutOfBoundsException();
        }

        public void setIcon(Image img, int i)
        {
            throw new UnsupportedOperationException();
        }

        public Dimension getIconSize(IMapMode mapMode, int i)
        {
            if (i == 0)
            {
                return getTotalIconSize(mapMode);
            }

            throw new IndexOutOfBoundsException();
        }

        public int getNumberofIcons()
        {
            return 1;
        }

        public Dimension getTotalIconSize(IMapMode mapMode)
        {
            if (totalIconSize != null)
                return totalIconSize;

            if (icon != null && !icon.isDisposed())
            {
                org.eclipse.swt.graphics.Rectangle imgBounds = icon.getBounds();
                totalIconSize = new Dimension(mapMode.DPtoLP(imgBounds.width), mapMode.DPtoLP(imgBounds.height));
            }
            else
            {
                totalIconSize = EMPTY_DIMENSION;
            }

            return totalIconSize;
        }

        public void invalidate()
        {
            totalIconSize = null;
        }

    }
    
    /**
     * The cached truncation string size.
     */
    private Dimension truncationStringSize;
    /**
     * Construct an empty wrapping label.
     */
    public WrappingLabelCustom()
    {
        super();
        fix();
    }

    /**
     * per;it to fix qttribute construction by reflection
     */
    private void fix()
    {
        try
        {
            if (fFlowPage != null)
            {
                TextFlowEx textFlow = new TextFlowExCustom();
                fFlowPage.setAccessible(true);
                FlowPage flowPageReflect = (FlowPage) fFlowPage.get(this); 
                if (flowPageReflect.getChildren().size() >= 1)
                {
                    flowPageReflect.getChildren().remove(0);
                }
                flowPageReflect.add(textFlow,0);
                TextLayout layout;
                layout = new TruncatedSingleLineTextLayout(textFlow,
                        getTruncationString());
                layout.setFlowContext((FlowContext) ((FlowPage) textFlow.getParent())
                    .getLayoutManager());
                textFlow.setLayoutManager(layout);
                fFlowPage.setAccessible(false);
            }
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * We get the field once to avoid multiple access to class
     */
    private static Field fFlowPage = getField () ;
    
    static Field getField ()
    {
        Class< ? > tmp = WrappingLabel.class;
        if (tmp != null)
        {
            Class< ? > owner = tmp;
            Field fFlowPage;
            try
            {
                fFlowPage = owner.getDeclaredField("flowPage");
                return fFlowPage;
            }
            catch (SecurityException e)
            {
                e.printStackTrace();
            }
            catch (NoSuchFieldException e)
            {
                e.printStackTrace();
            }
        }
        return null ;
    }
    
    /**
     * Construct a wrapping label with the passed String as its text.
     * 
     * @param text the label text
     */
    public WrappingLabelCustom(String text)
    {
        super(text);
        fix();
        // we rechange text value after fix
        if (text != null) {
            setText(text);
        } else {
            setText("");//$NON-NLS-1$
        }
    }

    /**
     * Construct a wrapping label with thepassed Image as its icon.
     * 
     * @param image the label image
     */
    public WrappingLabelCustom(Image image)
    {
        super(image);
        fix();
    }

    /**
     * Construct a wrapping label with passed the String as its text and the passed Image as its icon.
     * 
     * @param text the label text
     * @param image the label image
     */
    public WrappingLabelCustom(String text, Image image)
    {
        super(text, image);
        fix();
        // we rechange text value after fix
        if (text != null) {
            setText(text);
        } else {
            setText("");//$NON-NLS-1$
        }
    }

    /**
     * @return <code>IMapMode</code> used by this figure. <code>IMapMode</code> that allows for the coordinate mapping
     *         from device to logical units.
     */
    IMapMode getFigureMapMode()
    {
        return getMapModeConstants().mapModeRef.get();
    }
    
    MapModeConstants getMapModeConstants()
    {
        if (mapModeConstants == null)
        {
            IMapMode mapMode = MapModeUtil.getMapMode(this);
            while (mapMode instanceof IMapModeHolder)
            {
                mapMode = ((IMapModeHolder) mapMode).getMapMode();
            }
            mapModeConstants = mapModeConstantsMap.get(mapMode);
            if (mapModeConstants == null)
            {
                mapModeConstants = new MapModeConstants(mapMode);
                mapModeConstantsMap.put(mapMode, mapModeConstants);
            }
        }
        return mapModeConstants;
    }
    public Dimension getMinimumSize(int w, int h)
    {
        if (minSize != null)
            return minSize;
        minSize = new Dimension();

        Font currentFont = getFont();
        Dimension ellipsisSize = getTruncationStringSize();
        Dimension textSize = new TextUtilitiesExCustom(getFigureMapMode()).getTextExtents(getText(), currentFont);
        if (textSize.width == 0)
        {
            textSize.height = 0;
        }
        textSize.intersect(ellipsisSize);

        Dimension labelSize = calculateLabelSize(textSize);
        Insets insets = getInsets();
        labelSize.expand(insets.getWidth(), insets.getHeight());
        minSize.union(labelSize);
        return minSize;
    }
    /**
     * Returns the size of the truncation string based on the currently used Map mode size.
     * 
     * @return the size of the truncation string
     * 
     */
    Dimension getTruncationStringSize()
    {
        if (truncationStringSize == null)
        {
            if (getTruncationString().equals(ELLIPSIS))
            {
                truncationStringSize = getMapModeConstants().getEllipseTextSize(getFont());
            }
            else
            {
                Font f = getFont();
                IMapMode mapMode = getFigureMapMode();
                truncationStringSize = FigureUtilities.getTextExtents(getTruncationString(), f);
                truncationStringSize.height = FigureUtilities.getFontMetrics(f).getHeight();
                truncationStringSize = new Dimension(mapMode.DPtoLP(truncationStringSize.width), mapMode.DPtoLP(truncationStringSize.height));
            }
        }
        return truncationStringSize;
    }
}
