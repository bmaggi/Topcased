/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
 
/**
 * Load a new page on the documentation frame.
 * 
 * @param doc The documentation page to be displayed inside the documentation
 *            frame
 * @see index.html The documentation fame is defined in this file with the name
 *                 'docframe'  
 * */ 
function changeDoc(doc, event)
{
  if(event.ctrlKey == false){
  	parent.docframe.location.replace(doc);
	}
}