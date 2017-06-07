package org.topcased.richtext.common.ui;

import org.topcased.richtext.common.IContextProvider;
import org.topcased.richtext.common.ui.util.MsgBox;

/**
 * content provider for non-ui plugins
 * 
 * @author Jinhua Xi
 * @since 1.5
 *
 */
public class ContextProvider implements IContextProvider {

	public Object getContext() {
		//TODO: revisit
		Object ctx = null;
		try {
			ctx = CommonUIPlugin.getDefault().getWorkbench().getDisplay().getActiveShell();
		}
		catch(Exception e) {
			//
		}
		return ctx != null ? ctx : MsgBox.getDefaultShell();
	}

}
