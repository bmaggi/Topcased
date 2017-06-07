/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (ATOS ORIGIN INTEGRATION) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.regexviewer.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class RegexViewerComposite extends Composite
{
    public static int MATCH = 1;

    public static int SPLIT = 1 << 1;

    public static int GROUP = 1 << 2;
    
    public static int EXPANDABLE = 1 << 3;
    
    public static int EXPANDED = 1 << 4;
    
    public static int DESCRIPTION = 1 << 5;

    /** The toolkit. */
    private FormToolkit toolkit;

    /** The form. */
    private Form form;

    /** The tree. */
    private Tree tree;

    /** The btn split. */
    private Button btnSplit;

    /** The btn group. */
    private Button btnGroup;

    /** The text match. */
    private Text theTextMatch;

    /** The text string. */
    private Text theTextString;

    /** The text regex. */
    private Text theTextRegex;

    private int theOptions;

    private boolean split;

    private boolean group;

    private boolean match;

	private boolean expanded;

	private boolean expandable;

	private boolean description;
	
	private int patternFlag ;
	
	private Section section;

    public RegexViewerComposite(Composite parent, int style, int options)
    {
        this (parent,style,options,Pattern.MULTILINE | Pattern.DOTALL);
    }
    
    public RegexViewerComposite (Composite parent, int style, int options, int flagPatterns)
    {
        super(parent, style);
        theOptions = options;
        this.setLayout(new FillLayout());
        split = (theOptions & SPLIT) != 0 ;
        group = (theOptions & GROUP) != 0 ;
        match = (theOptions & MATCH) != 0 ;
        expanded = (theOptions & EXPANDED) != 0 ;
        expandable = (theOptions & EXPANDABLE) != 0 ;
        description = (theOptions & DESCRIPTION) != 0 ;
        patternFlag = flagPatterns ;
        createForm();
    }

    /**
     * Creates the form.
     * 
     * @param parent the parent
     */
    private void createForm()
    {
        toolkit = new FormToolkit(this.getDisplay());
        form = toolkit.createForm(this);
        toolkit.decorateFormHeading(form);
        FillLayout layout = new FillLayout();
        layout.spacing = 5;
        layout.marginHeight = 5;
        layout.marginWidth = 5;
        form.getBody().setLayout(layout);
        createSection(form);
    }

    /**
     * Creates the section.
     * 
     * @param mform the mform
     */
    private void createSection(Form mform)
    {
    	int style = Section.TITLE_BAR ;
    	if (expanded)
    	{
    		style |= Section.EXPANDED;
    	}
    	if (expandable)
    	{
    		style |= Section.TWISTIE;
    	}
    	if (description)
    	{
    		style |= Section.DESCRIPTION;
    	}
        section = toolkit.createSection(mform.getBody(), style);
        section.setText("Regex Viewer");
        Composite client = toolkit.createComposite(section);
        GridLayout layout = new GridLayout();
        layout.marginWidth = layout.marginHeight = 1;
        layout.numColumns = 2;
        layout.makeColumnsEqualWidth = false;
        client.setLayout(layout);
        section.setClient(client);
        toolkit.createLabel(client, "Regex : ");
        theTextRegex = toolkit.createText(client, "", SWT.BORDER);
        theTextRegex.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        theTextRegex.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                manageModifications();
            }
        });
        Label l2 = toolkit.createLabel(client, "String : ");
        l2.setLayoutData(new GridData(SWT.TOP, SWT.FILL, false, false, 1, 10));
        theTextString = toolkit.createText(client, "", SWT.MULTI | SWT.SCROLL_LINE | SWT.BORDER);
        theTextString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 10));
        theTextString.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                manageModifications();
            }
        });
        if (match)
        {
            createMatches(client);
        }
        if (split)
        {
            createSplit(client);
        }
        if (group)
        {
            createGroup(client);
        }
        if (group && !split)
        {
            btnGroup.setSelection(true);
        }
        if (!group && split)
        {
            btnSplit.setSelection(true);
        }
        if (split || group)
        {
            tree = toolkit.createTree(client, SWT.BORDER);
            tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
        }
    }

    private void createGroup(Composite client)
    {
        btnGroup = toolkit.createButton(client, "group", SWT.RADIO);
        btnGroup.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseUp(MouseEvent e)
            {
                manageModifications();
            }
        });
    }

    private void createSplit(Composite client)
    {
        btnSplit = toolkit.createButton(client, "split", SWT.RADIO);
        btnSplit.setSelection(true);
        btnSplit.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseUp(MouseEvent e)
            {
                manageModifications();
            }
        });
    }

    private void createMatches(Composite client)
    {
        toolkit.createLabel(client, "matches : ");
        theTextMatch = toolkit.createText(client, "", SWT.BORDER);
        theTextMatch.setEditable(false);
        theTextMatch.setEnabled(false);
        theTextMatch.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }

    /**
     * Manage modifications.
     */
    private void manageModifications()
    {
        if (split || group)
        {
            tree.removeAll();
        }
        try
        {
            Pattern p = Pattern.compile(theTextRegex.getText(), patternFlag);
            Matcher m = p.matcher(theTextString.getText());
            boolean result = m.matches();
            if (match)
            {
                theTextMatch.setText(String.valueOf(result));
            }
            if (split || group)
            {
                String[] strings = null;
                form.setMessage(null);
                if (group && btnGroup.getSelection())
                {
                    if (result)
                    {
                        m.group();
                        strings = new String[m.groupCount()];
                        for (int i = 1; i <= m.groupCount(); i++)
                        {
                            strings[i - 1] = m.group(i);
                        }
                    }
                }
                else if (split)
                {
                    strings = p.split(theTextString.getText());
                }
                if (strings != null)
                {
                    for (String s : strings)
                    {
                        TreeItem item = new TreeItem(tree, SWT.NONE);
                        if (s != null)
                        {
                            item.setText(s);
                        }
                    }
                }
                
            }
            form.setMessage(null);
        }
        catch (PatternSyntaxException p)
        {
            form.setMessage("Regex doesn't compile", IMessageProvider.ERROR);
        }
        catch (IllegalStateException e)
        {
            form.setMessage("Group not possible", IMessageProvider.ERROR);
        }
    }
    
    /**
     * Sets the regex.
     * 
     * @param text the new regex
     */
    public void setRegex(String text)
    {
    	theTextRegex.setText(text);
    }
    
    /**
     * Sets the text.
     * 
     * @param text the new text
     */
    public void setText (String text)
    {
    	theTextString.setText(text);
    }
    
    /**
     * Sets the description.
     * 
     * @param descriptionText the new description
     */
    public void setDescription(String descriptionText)
    {
    	if (description)
    	{
    		section.setDescription(descriptionText);
    	}
    }
}
