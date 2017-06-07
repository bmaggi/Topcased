/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.documentation;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * A class defining an abstract composite used to edit the documentation related to a semantic element.<br>
 * <br>
 * Created : 11 August 2009<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractCommentsComposite extends DocPageComposite
{
    /** The model element to be documented */
    private EObject documentedElement;

    /** A composite used to edit the documentation using a Rich Text editor */
    private RichTextComposite richTextComposite;

    /** A composite used to edit the documentation using a Plain Text editor */
    private PlainTextComposite plainTextComposite;

    private Button useRichTextEditorButton;

    private Button editButton;

    private Composite editorContainer;

    private FocusListener focusListener;

    private static boolean isRichTextEnabled = true;

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param commandStack the command stack to use to execute commands
     * @deprecated use {@link #AbstractCommentsComposite(Composite, int, IEditingDomainProvider)} instead
     */
    public AbstractCommentsComposite(Composite parent, int style, CommandStack commandStack)
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
    public AbstractCommentsComposite(Composite parent, int style, IEditingDomainProvider editingDomainProvider)
    {
        super(parent, style, editingDomainProvider);
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected void createContents(Composite parent)
    {
        parent.setLayout(new GridLayout(3, false));

        editorContainer = new Composite(parent, SWT.NONE);
        GridData gData = new GridData(GridData.FILL_BOTH);
        gData.horizontalSpan = 3;
        editorContainer.setLayoutData(gData);
        editorContainer.setLayout(new FillLayout());

        if (isRichTextEnabled)
        {
            try
            {
                Browser browser = new Browser(editorContainer, SWT.NONE);
                browser.dispose();
            }
            catch (SWTError swtError)
            {
                ModelerPlugin.log("None XULRunner installed. You can not use Rich Text Edition.", IStatus.WARNING);
                isRichTextEnabled = false;
            }
        }

        // Initialize editor depending of editors preferences
        if (ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR) && isRichTextEnabled)
        {
            // Rich Text Editor
            richTextComposite = createRichCommentsComposite();
        }
        else
        {
            // Simple Text Editor
            plainTextComposite = createEAnnotationCommentsComposite();
        }

        useRichTextEditorButton = new Button(parent, SWT.CHECK | SWT.RIGHT);
        useRichTextEditorButton.setText("Use HTML Editor");
        useRichTextEditorButton.setImage(ModelerImageRegistry.getImage("HTML_EDITOR"));
        useRichTextEditorButton.setSelection(ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR) && isRichTextEnabled);
        useRichTextEditorButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                changeEditor();
            }
        });

        Label emptyLbl = new Label(parent, SWT.NONE);
        emptyLbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        editButton = new Button(parent, SWT.PUSH);
        editButton.setImage(ModelerImageRegistry.getImage("EDIT"));
        editButton.setText("Edit");
        editButton.setEnabled(useRichTextEditorButton.getSelection());
        editButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                RichTextEditorDialog dialog = new RichTextEditorDialog(ModelerPlugin.getActiveWorkbenchShell(), getDocumentationValueFromElement());
                if (dialog.open() == Window.OK)
                {
                    richTextComposite.setDocumentationValue(dialog.getDocumentationValue());
                    handleDocChanged();
                }

            }
        });
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#refresh()
     */
    protected void refresh()
    {
        useRichTextEditorButton.setEnabled(getDocumentedElement() != null);
        if (useRichTextEditorButton.getSelection())
        {
            richTextComposite.setDocumentationValue("");
            if (getDocumentedElement() != null)
            {
                richTextComposite.setDocumentationValue(getDocumentationValueFromElement());
            }
        }
        else
        {
            plainTextComposite.setDocumentationValue("");
            plainTextComposite.getControl().setEnabled(getDocumentedElement() != null);
            if (getDocumentedElement() != null)
            {
                plainTextComposite.setDocumentationValue(getDocumentationValueFromElement());
            }
        }
    }

    /**
     * @return the richTextComposite
     */
    protected RichTextComposite getRichTextComposite()
    {
        return richTextComposite;
    }

    /**
     * @return the plainTextComposite
     */
    public PlainTextComposite getPlainTextComposite()
    {
        return plainTextComposite;
    }

    /**
     * Change the edited object
     * 
     * @param modelElement the edited object
     */
    public void setDocumentedElement(EObject modelElement)
    {
        if (modelElement == null || this.documentedElement != modelElement)
        {
            this.documentedElement = modelElement;
            refresh();
        }
    }

    /**
     * Get the element to be documented
     * 
     * @return EObject
     */
    public EObject getDocumentedElement()
    {
        return documentedElement;
    }

    /**
     * Change comments editor between simple Text Editor to HTML Text Editor and
     */
    public void changeEditor()
    {
        if (!useRichTextEditorButton.getSelection())
        {
            String comment = richTextComposite.getDocumentationValue();
            richTextComposite.dispose();
            plainTextComposite = createEAnnotationCommentsComposite();
            plainTextComposite.setFocus();
            plainTextComposite.setDocumentationValue(comment);
            useRichTextEditorButton.setToolTipText("Use HTML Editor to edit documentation");
            useRichTextEditorButton.setSelection(false);
            editButton.setEnabled(false);
        }
        else
        {
            if (isRichTextEnabled)
            {
                String comment = plainTextComposite.getDocumentationValue();
                plainTextComposite.getControl().removeFocusListener(focusListener);
                plainTextComposite.dispose();
                richTextComposite = createRichCommentsComposite();
                richTextComposite.setDocumentationValue(comment);
                useRichTextEditorButton.setToolTipText("Use Text Editor to edit documentation");
                useRichTextEditorButton.setSelection(true);
                editButton.setEnabled(true);
                editButton.setFocus();
            }
            else
            {
                showMessageDialog();
                useRichTextEditorButton.setSelection(false);
            }
        }
        editorContainer.layout();
    }

    private void showMessageDialog()
    {
        MessageDialog dialog = new MessageDialog(ModelerPlugin.getActiveWorkbenchShell(), "Rich Text Edition unavailable", null,
                "Your operating system does not support the SWT Browser component, thus you are not able to edit documentation using rich text capabilities.\n"
                        + "You should try installing XULRunner in your environment so that you can enable Rich Text Edition, and then restart your application.\n"
                        + "To install XulRunner, have a look at : <a>http://www.eclipse.org/atf/downloads/base_files/manualXulrunner_section.php</a>.", MessageDialog.WARNING,
                new String[] {IDialogConstants.OK_LABEL}, 0)
        {
            @Override
            protected Control createMessageArea(Composite composite)
            {
                Image image = getImage();
                if (image != null)
                {
                    imageLabel = new Label(composite, SWT.NULL);
                    image.setBackground(imageLabel.getBackground());
                    imageLabel.setImage(image);
                    GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BEGINNING).applyTo(imageLabel);
                }
                // create message
                if (message != null)
                {
                    Link messageLink = new Link(composite, getMessageLabelStyle());
                    messageLink.setText(message);
                    messageLink.addListener(SWT.Selection, new Listener()
                    {
                        public void handleEvent(Event event)
                        {
                            try
                            {
                                PlatformUI.getWorkbench().getBrowserSupport().createBrowser(null).openURL(new URL(event.text));
                                okPressed();
                            }
                            catch (PartInitException e)
                            {
                                ModelerPlugin.log(e);
                            }
                            catch (MalformedURLException e)
                            {
                                ModelerPlugin.log(e);
                            }
                        }
                    });
                    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).hint(convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH), SWT.DEFAULT).applyTo(
                            messageLink);
                }
                return composite;
            }
        };
        dialog.open();
    }

    /**
     * Create the Composite used to render the Rich Text Editor
     * 
     * @return RichTextCommentsComposite
     */
    protected RichTextComposite createRichCommentsComposite()
    {
        richTextComposite = new RichTextComposite(editorContainer, SWT.NONE);

        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        richTextComposite.setLayout(layout);

        return richTextComposite;
    }

    /**
     * Create the Composite used to render the Plain text editor
     * 
     * @return PlainTextComposite
     */
    protected PlainTextComposite createEAnnotationCommentsComposite()
    {
        plainTextComposite = new PlainTextComposite(editorContainer, SWT.NONE);
        focusListener = new FocusAdapter()
        {
            private String previousComment;

            public void focusGained(FocusEvent e)
            {
                previousComment = plainTextComposite.getDocumentationValue();
            }

            public void focusLost(FocusEvent e)
            {
                if (!plainTextComposite.getDocumentationValue().equals(previousComment))
                {
                    handleDocChanged();
                }
            }
        };

        plainTextComposite.getTextControl().addFocusListener(focusListener);
        return plainTextComposite;
    }

    /**
     * @see org.eclipse.swt.widgets.Composite#setFocus()
     */
    public boolean setFocus()
    {
        if (useRichTextEditorButton == null)
        {
            return false;
        }
        if (useRichTextEditorButton.getSelection())
        {
            return editButton.setFocus();
        }
        if (plainTextComposite == null)
        {
            return false;
        }
        return plainTextComposite.setFocus();
    }

    /**
     * Gets the checkbox allowing to use rich text edition
     * 
     * @return the useRichTextEditorButton
     */
    protected Button getUseRichTextEditorButton()
    {
        return useRichTextEditorButton;
    }

    /**
     * Gets the edit button
     * 
     * @return the edit button
     */
    protected Button getEditButton()
    {
        return editButton;
    }

    /**
     * Get the String value of the element to be edited.<br/>
     * Subclasses may override this in order to supply the documentation text from their element.
     * 
     * @return String the documentation text
     */
    protected abstract String getDocumentationValueFromElement();

    /**
     * Update documentation text using a Command. Subclasses may override this in order to supply their own
     * implementation
     */
    public abstract void handleDocChanged();

    @Override
    public void setEnabled(boolean enabled)
    {
        if (plainTextComposite != null)
        {
            plainTextComposite.setEnabled(enabled);
        }
        if (richTextComposite != null)
        {
            richTextComposite.setEnabled(enabled);
        }
        if (useRichTextEditorButton != null)
        {
            useRichTextEditorButton.setEnabled(enabled);
        }
    }

    @Override
    public void setForeground(Color color)
    {
        super.setForeground(color);
        if (plainTextComposite != null)
        {
            plainTextComposite.setForeground(color);
        }
        if (richTextComposite != null)
        {
            richTextComposite.setForeground(color);
        }
    }

}
