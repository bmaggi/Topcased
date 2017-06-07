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
package org.topcased.modeler;

import org.eclipse.swt.graphics.Color;

/**
 * A collection of color-related constants. Creation : 25 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface ModelerColorConstants
{
    Color COLOR_ERROR = ColorRegistry.getInstance().get("255,128,128");

    Color COLOR_WARNING = ColorRegistry.getInstance().get("249,240,163");

    Color COLOR_INFO = ColorRegistry.getInstance().get("128,128,255");

    Color white = ColorRegistry.getInstance().get("255,255,255");

    Color black = ColorRegistry.getInstance().get("0,0,0");

    Color red = ColorRegistry.getInstance().get("255,0,0");

    Color yellow = ColorRegistry.getInstance().get("255,255,0");

    Color green = ColorRegistry.getInstance().get("0,255,0");

    Color blue = ColorRegistry.getInstance().get("0,0,255");

    Color lightOrange = ColorRegistry.getInstance().get("255,195,0");

    Color darkOrange = ColorRegistry.getInstance().get("255,120,0");

    Color selectGray = ColorRegistry.getInstance().get("192,192,192");

    Color lightRed = ColorRegistry.getInstance().get("255,200,200");

    Color lightGray = ColorRegistry.getInstance().get("245,245,245");

    Color lightGray2 = ColorRegistry.getInstance().get("215,215,215");

    Color lightBlue = ColorRegistry.getInstance().get("200,230,255");

    Color lightGreen = ColorRegistry.getInstance().get("200,255,200");

    Color lightYellow = ColorRegistry.getInstance().get("255,255,200");

    Color lightPurple = ColorRegistry.getInstance().get("255,200,255");

    Color darkBrown = ColorRegistry.getInstance().get("139,69,19");

    Color lightBrown = ColorRegistry.getInstance().get("244,164,96");

    Color bluePort = ColorRegistry.getInstance().get("30,20,180");

    Color greenPort = ColorRegistry.getInstance().get("20,100,20");

    Color classlightRed = ColorRegistry.getInstance().get("255,220,220");

    Color classRed = ColorRegistry.getInstance().get("255,180,180");

    Color classlightGreen = ColorRegistry.getInstance().get("220,255,220");

    Color classGreen = ColorRegistry.getInstance().get("180,255,180");

    Color classlightBlue = ColorRegistry.getInstance().get("220,250,255");

    Color classBlue = ColorRegistry.getInstance().get("180,210,255");

    Color classlightGray = ColorRegistry.getInstance().get("245,245,245");

}
