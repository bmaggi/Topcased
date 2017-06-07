package org.topcased.richtext.common;


public interface IMessageCallback {

	public void displayWarning(AbstractActivator plugin, String title, String msg, String reason);
	public void displayWarning(AbstractActivator plugin, String msg, String reason, Throwable ex);
	public void displayWarning(AbstractActivator plugin, String msg, String reason, String details, Throwable ex);
	public void displayWarning(AbstractActivator plugin, String title, String msg, String reason, String details, Throwable ex);
	
	public void displayError(AbstractActivator plugin, String title, String msg);
	public void displayError(AbstractActivator plugin, String title, String msg, Throwable ex);
	public void displayError(AbstractActivator plugin, String title, String msg, String reason, String details, Throwable ex);
	

}
