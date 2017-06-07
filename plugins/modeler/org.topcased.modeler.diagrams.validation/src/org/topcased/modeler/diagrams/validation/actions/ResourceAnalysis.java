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
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.diagrams.validation.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

/**
 * Class analysing resources to fix problem or just change path of resources in a di
 * 
 * @author tfaure
 * 
 */
public class ResourceAnalysis
{

    /**
     * Opens the di at the specified UTI and opens a dialog allowing a user to change the path
     * 
     * @param uri the uri to process
     * @param monitor
     */
    public void process(final URI uri) throws Exception
    {
        Shell activeShell = Display.getDefault().getActiveShell();
        ProgressMonitorDialog dialog = new ProgressMonitorDialog(activeShell);
        try
        {
            // resource analysis to determine the resource used in the model
            ResourceAnalyser resourceAnalyser = new ResourceAnalyser(uri);
            dialog.run(false, false, resourceAnalyser);
            final ResourceSet resourceSet = resourceAnalyser.getResourceSet();
            if (resourceSet == null)
            {
                return;
            }
            // display to the user all the resources uris
            final Map<String, String> map = getMap(resourceSet);
            if (map != null && !map.isEmpty())
            {
                ProgressMonitorDialog dialog2 = new ProgressMonitorDialog(activeShell);
                dialog2.run(false, false, new IRunnableWithProgress()
                {

                    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
                    {
                        monitor.beginTask("Process modifications", 2);
                        unload(resourceSet);
                        monitor.worked(1);
                        // if the user has made modifications the modification are commited
                        try
                        {
                            applyModifications(uri, monitor, map);
                        }
                        catch (Exception e)
                        {
                            throw new InvocationTargetException(e,e.getMessage());
                        }
                    }
                });
            }
            else
            {
                unload(resourceSet);
            }
        }
        catch (InvocationTargetException e)
        {
            throw e;
        }
        catch (InterruptedException e)
        {
        }

    }

    /**
     * Return a Map of Resource Mapping for the given resource set
     * 
     * @param resourceSet
     * @return a map or null if there is nothing to do
     */
    protected Map<String, String> getMap(ResourceSet resourceSet)
    {
        Shell activeShell = Display.getDefault().getActiveShell();
        ChangeResourceDialog changeDialog = new ChangeResourceDialog(activeShell, resourceSet.getResources());
        if (changeDialog.open() == ChangeResourceDialog.OK)
        {
            return changeDialog.getResult();
        }
        return null;
    }

    /**
     * Apply resource uri modification
     * 
     * @param uri
     * @param monitor
     * @param result
     * @throws Exception
     */
    protected void applyModifications(URI uri, IProgressMonitor monitor, Map<String, String> result) throws Exception
    {
        monitor.subTask("Apply Modifications");
        ResourceSet set2 = new CustomResSet(result);
        set2.getResource(uri, true);
        EcoreUtil.resolveAll(set2);
        monitor.subTask("Save");
        for (Resource r : set2.getResources())
        {
            try
            {
                r.save(set2.getLoadOptions());
            }
            catch (UnknownServiceException e1)
            {
            }
            catch (Exception e)
            {
                throw new Exception("An exception occured during save of " + r.getURI().toString() + " : " + e.getMessage(), e);
            }
        }
        monitor.worked(1);
        monitor.subTask("Unload");
        unload(set2);
    }

    protected void unload(ResourceSet set)
    {
        for (Resource r : set.getResources())
        {
            try
            {
                r.unload();
            }
            catch (Exception e)
            {
            }
        }
    }

    /**
     * Process which analyse a resource
     * 
     * @author tfaure
     * 
     */
    protected final class ResourceAnalyser implements IRunnableWithProgress
    {
        private final URI uri;

        private ResourceSet set;

        private ResourceAnalyser(URI uri)
        {
            this.uri = uri;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
        {
            monitor.beginTask("Analyse your model " + uri.toString(), 2);
            if (uri.fileExtension().endsWith("di"))
            {
                set = new ResourceSetImpl();
                monitor.worked(1);
                set.getResource(uri, true);
                EcoreUtil.resolveAll(set);
                monitor.worked(1);
            }
        }

        public ResourceSet getResourceSet()
        {
            return set;
        }
    }

    /**
     * Dialog able to change resources uri
     * 
     * @author tfaure
     * 
     */
    protected class ChangeResourceDialog extends Dialog
    {
        private final List<String> resources;

        private final List<EditResourceURI> fields;

        protected ChangeResourceDialog(Shell parentShell, List<Resource> resources)
        {
            super(parentShell);
            this.resources = new ArrayList<String>(resources.size());
            for (Resource r : resources)
            {
                this.resources.add(r.getURI().toString());
            }
            fields = new ArrayList<ResourceAnalysis.EditResourceURI>(resources.size());
        }

        @Override
        protected void configureShell(Shell newShell)
        {
            super.configureShell(newShell);
            newShell.setText("Resource Analysis");
        }

        @Override
        protected Control createDialogArea(Composite parent)
        {
            Label label = new Label(parent, SWT.NONE);
            label.setText(" This dialog allows you to change a path to resource registered in your model.\n For platform and file uris, the validity of the path is checked.\n If the field is red it mean the path is not correct");
            ScrolledComposite compo = new ScrolledComposite(parent, SWT.V_SCROLL);
            compo.setLayout(new FillLayout());
            compo.setLayoutData(new GridData(GridData.FILL_BOTH));
            final Composite top = new Composite(compo, SWT.NONE);
            compo.setContent(top);
            top.setLayout(new FillLayout(SWT.VERTICAL));
            for (String r : resources)
            {
                fields.add(new EditResourceURI(top, r));
            }
            top.setSize(top.computeSize(SWT.DEFAULT, SWT.DEFAULT));
            top.layout();
            return parent;
        }

        public Map<String, String> getResult()
        {
            Map<String, String> map = new HashMap<String, String>();
            for (EditResourceURI e : fields)
            {
                if (e.hasChanged())
                {
                    map.put(e.getOldURI(), e.getNewURI());
                }
            }
            return map;
        }

    }

    /**
     * @author tfaure a row to change resource uris
     */
    protected class EditResourceURI
    {
        private final String originalURI;

        private String newURI;

        Text text = null;

        Button button = null;

        EditResourceURI(Composite c, String r)
        {
            this.originalURI = r;
            newURI = r;
            Composite newOne = new Composite(c, SWT.NONE);
            GridLayout gridLayout = new GridLayout(2, false);
            newOne.setLayout(gridLayout);
            text = new Text(newOne, SWT.BORDER);
            text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            text.addModifyListener(new ModifyListener()
            {
                public void modifyText(ModifyEvent arg0)
                {
                    newURI = text.getText();
                    try
                    {
                        URI tmp = URI.createURI(newURI);
                        if (tmp.isPlatform())
                        {
                            if (tmp.isPlatformResource())
                            {
                                IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(tmp.toPlatformString(true)));
                                if (!f.exists())
                                {
                                    setNotExist();
                                }
                                else
                                {
                                    setExist();
                                }
                            }
                            else
                            {
                                if (tmp.segmentCount() > 2)
                                {
                                    String[] segments = tmp.segments();
                                    String bundle = segments[1];
                                    Bundle plugin = Platform.getBundle(bundle);
                                    if (plugin != null)
                                    {
                                        StringBuilder builder = new StringBuilder();
                                        for (int i = 2; i < segments.length; i++)
                                        {
                                            builder.append("/");
                                            builder.append(segments[i]);
                                        }
                                        URL url = plugin.getEntry(builder.toString());
                                        if (url != null)
                                        {
                                            setExist();
                                        }
                                        else
                                        {
                                            setNotExist();
                                        }
                                    }

                                }

                            }
                        }
                        else if (tmp.isFile())
                        {
                            File f = new File(tmp.toFileString());
                            if (!f.exists())
                            {
                                setNotExist();
                            }
                            else
                            {
                                setExist();
                            }
                        }
                        else
                        {
                            setExist();
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        setNotExist();
                    }
                }

                private void setExist()
                {
                    text.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
                }

                private void setNotExist()
                {
                    text.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
                }
            });
            text.setText(r);
            button = new Button(newOne, SWT.NONE);
            button.setText("Browse ...");
            button.addSelectionListener(new SelectionListener()
            {
                public void widgetSelected(SelectionEvent arg0)
                {
                    ResourceDialog dialog = new ResourceDialog(Display.getDefault().getActiveShell(), "Choose new URI", SWT.OPEN);
                    if (dialog.open() == ResourceDialog.OK)
                    {
                        text.setText(dialog.getURIText());
                    }
                }

                public void widgetDefaultSelected(SelectionEvent arg0)
                {
                }
            });

        }

        public String getNewURI()
        {
            return newURI;
        }

        public String getOldURI()
        {
            return originalURI;
        }

        public boolean hasChanged()
        {
            return !newURI.equals(originalURI);
        }
    }

    /**
     * A resource set which load resources defined by users instead of original resources
     * 
     * @author tfaure
     * 
     */
    protected class CustomResSet extends ResourceSetImpl
    {
        private final Map<String, String> map;

        public CustomResSet(Map<String, String> map)
        {
            this.map = map;
            for (String s : map.values())
            {
                getResource(URI.createURI(s), true);
            }
        }
        
        @Override
        public Resource getResource(URI uri, boolean loadOnDemand)
        {
            if (uri != null && map != null && map.containsKey(uri.toString()))
            {
                String theUri = map.get(uri.toString());
                URI createURI = URI.createURI(theUri);
                return super.getResource(createURI, loadOnDemand);
            }
            return super.getResource(uri, loadOnDemand);
        }
    }

}
