/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramConfigurationImpl.java,v 1.8 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.LayoutType;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteItem;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getPalette <em>Palette</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getDefaultFont <em>Default Font</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getTemplateRootObject <em>Template Root Object</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#isForceOverwrite <em>Force Overwrite</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#isOverwriteGraphConf <em>Overwrite Graph Conf</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#isOrganizeImports <em>Organize Imports</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getEditorConfigurator <em>Editor Configurator</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getCopyrightText <em>Copyright Text</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getPluginVersion <em>Plugin Version</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl#isSamePluginAsEditor <em>Same Plugin As Editor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramConfigurationImpl extends EObjectImpl implements DiagramConfiguration
{
    /**
     * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected static final String PROJECT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected String projectName = PROJECT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected String package_ = PACKAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getPalette() <em>Palette</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPalette()
     * @generated
     * @ordered
     */
    protected PaletteConfiguration palette;

    /**
     * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getParts()
     * @generated
     * @ordered
     */
    protected EList<PartConfiguration> parts;

    /**
     * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected static final LayoutType LAYOUT_EDEFAULT = LayoutType.XY_LAYOUT_LITERAL;

    /**
     * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected LayoutType layout = LAYOUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getObjects()
     * @generated
     * @ordered
     */
    protected EList<ObjectConfiguration> objects;

    /**
     * The cached value of the '{@link #getGenModel() <em>Gen Model</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getGenModel()
     * @generated
     * @ordered
     */
    protected GenModel genModel;

    /**
     * The default value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_BACKGROUND_COLOR_EDEFAULT = (Color)DiagramconfiguratorFactory.eINSTANCE.createFromString(DiagramconfiguratorPackage.eINSTANCE.getColor(), "255,255,255");

    /**
     * The cached value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultBackgroundColor = DEFAULT_BACKGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_FOREGROUND_COLOR_EDEFAULT = (Color)DiagramconfiguratorFactory.eINSTANCE.createFromString(DiagramconfiguratorPackage.eINSTANCE.getColor(), "0,0,0");

    /**
     * The cached value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultForegroundColor = DEFAULT_FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected static final Font DEFAULT_FONT_EDEFAULT = (Font)DiagramconfiguratorFactory.eINSTANCE.createFromString(DiagramconfiguratorPackage.eINSTANCE.getFont(), "");

    /**
     * The cached value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected Font defaultFont = DEFAULT_FONT_EDEFAULT;

    /**
     * The cached value of the '{@link #getTemplateRootObject() <em>Template Root Object</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTemplateRootObject()
     * @generated
     * @ordered
     */
    protected GenClass templateRootObject;

    /**
     * The default value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #isForceOverwrite()
     * @generated
     * @ordered
     */
    protected static final boolean FORCE_OVERWRITE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #isForceOverwrite()
     * @generated
     * @ordered
     */
    protected boolean forceOverwrite = FORCE_OVERWRITE_EDEFAULT;

    /**
     * The default value of the '{@link #isOverwriteGraphConf() <em>Overwrite Graph Conf</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isOverwriteGraphConf()
     * @generated
     * @ordered
     */
    protected static final boolean OVERWRITE_GRAPH_CONF_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isOverwriteGraphConf() <em>Overwrite Graph Conf</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isOverwriteGraphConf()
     * @generated
     * @ordered
     */
    protected boolean overwriteGraphConf = OVERWRITE_GRAPH_CONF_EDEFAULT;

    /**
     * The default value of the '{@link #isOrganizeImports() <em>Organize Imports</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isOrganizeImports()
     * @generated
     * @ordered
     */
    protected static final boolean ORGANIZE_IMPORTS_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isOrganizeImports() <em>Organize Imports</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #isOrganizeImports()
     * @generated
     * @ordered
     */
    protected boolean organizeImports = ORGANIZE_IMPORTS_EDEFAULT;

    /**
     * The cached value of the '{@link #getEditorConfigurator() <em>Editor Configurator</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEditorConfigurator()
     * @generated
     * @ordered
     */
    protected EditorConfiguration editorConfigurator;

    /**
     * The default value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getCopyrightText()
     * @generated
     * @ordered
     */
    protected static final String COPYRIGHT_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getCopyrightText()
     * @generated
     * @ordered
     */
    protected String copyrightText = COPYRIGHT_TEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getPluginVersion()
     * @generated NOT
     * @ordered
     */
    protected static final String PLUGIN_VERSION_EDEFAULT = (String) DiagramConfiguratorPlugin.getPlugin().getBundle().getHeaders().get(org.osgi.framework.Constants.BUNDLE_VERSION);

    /**
     * The cached value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getPluginVersion()
     * @generated
     * @ordered
     */
    protected String pluginVersion = PLUGIN_VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getProvider()
     * @generated
     * @ordered
     */
    protected static final String PROVIDER_EDEFAULT = "Topcased";

    /**
     * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getProvider()
     * @generated
     * @ordered
     */
    protected String provider = PROVIDER_EDEFAULT;

    /**
     * The default value of the '{@link #isSamePluginAsEditor() <em>Same Plugin As Editor</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSamePluginAsEditor()
     * @generated
     * @ordered
     */
    protected static final boolean SAME_PLUGIN_AS_EDITOR_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSamePluginAsEditor() <em>Same Plugin As Editor</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSamePluginAsEditor()
     * @generated
     * @ordered
     */
    protected boolean samePluginAsEditor = SAME_PLUGIN_AS_EDITOR_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramConfigurationImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> In the case of the generation in the same plugin as the editor, the project name is
     * retrieved from the editor one. <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getProjectName()
    {
        if (isSamePluginAsEditor() && getEditorConfigurator() != null)
        {
            return getEditorConfigurator().getProjectName();
        }

        return projectName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setProjectName(String newProjectName)
    {
        String oldProjectName = projectName;
        projectName = newProjectName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME, oldProjectName, projectName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getPackage()
    {
        return package_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPackage(String newPackage)
    {
        String oldPackage = package_;
        package_ = newPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE, oldPackage, package_));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPrefix(String newPrefix)
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX, oldPrefix, prefix));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PaletteConfiguration getPalette()
    {
        return palette;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPalette(PaletteConfiguration newPalette, NotificationChain msgs)
    {
        PaletteConfiguration oldPalette = palette;
        palette = newPalette;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, oldPalette, newPalette);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPalette(PaletteConfiguration newPalette)
    {
        if (newPalette != palette)
        {
            NotificationChain msgs = null;
            if (palette != null)
                msgs = ((InternalEObject)palette).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, null, msgs);
            if (newPalette != null)
                msgs = ((InternalEObject)newPalette).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, null, msgs);
            msgs = basicSetPalette(newPalette, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, newPalette, newPalette));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<PartConfiguration> getParts()
    {
        if (parts == null)
        {
            parts = new EObjectContainmentEList<PartConfiguration>(PartConfiguration.class, this, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS);
        }
        return parts;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public LayoutType getLayout()
    {
        return layout;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setLayout(LayoutType newLayout)
    {
        LayoutType oldLayout = layout;
        layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT, oldLayout, layout));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<ObjectConfiguration> getObjects()
    {
        if (objects == null)
        {
            objects = new EObjectContainmentEList<ObjectConfiguration>(ObjectConfiguration.class, this, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS);
        }
        return objects;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GenModel getGenModel()
    {
        if (genModel != null && genModel.eIsProxy())
        {
            InternalEObject oldGenModel = (InternalEObject)genModel;
            genModel = (GenModel)eResolveProxy(oldGenModel);
            if (genModel != oldGenModel)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
            }
        }
        return genModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GenModel basicGetGenModel()
    {
        return genModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setGenModel(GenModel newGenModel)
    {
        GenModel oldGenModel = genModel;
        genModel = newGenModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Color getDefaultBackgroundColor()
    {
        return defaultBackgroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultBackgroundColor(Color newDefaultBackgroundColor)
    {
        Color oldDefaultBackgroundColor = defaultBackgroundColor;
        defaultBackgroundColor = newDefaultBackgroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR, oldDefaultBackgroundColor, defaultBackgroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Color getDefaultForegroundColor()
    {
        return defaultForegroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultForegroundColor(Color newDefaultForegroundColor)
    {
        Color oldDefaultForegroundColor = defaultForegroundColor;
        defaultForegroundColor = newDefaultForegroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR, oldDefaultForegroundColor, defaultForegroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Font getDefaultFont()
    {
        return defaultFont;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultFont(Font newDefaultFont)
    {
        Font oldDefaultFont = defaultFont;
        defaultFont = newDefaultFont;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT, oldDefaultFont, defaultFont));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GenClass getTemplateRootObject()
    {
        if (templateRootObject != null && templateRootObject.eIsProxy())
        {
            InternalEObject oldTemplateRootObject = (InternalEObject)templateRootObject;
            templateRootObject = (GenClass)eResolveProxy(oldTemplateRootObject);
            if (templateRootObject != oldTemplateRootObject)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT, oldTemplateRootObject, templateRootObject));
            }
        }
        return templateRootObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GenClass basicGetTemplateRootObject()
    {
        return templateRootObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setTemplateRootObject(GenClass newTemplateRootObject)
    {
        GenClass oldTemplateRootObject = templateRootObject;
        templateRootObject = newTemplateRootObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT, oldTemplateRootObject, templateRootObject));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isForceOverwrite()
    {
        return forceOverwrite;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setForceOverwrite(boolean newForceOverwrite)
    {
        boolean oldForceOverwrite = forceOverwrite;
        forceOverwrite = newForceOverwrite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE, oldForceOverwrite, forceOverwrite));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isOverwriteGraphConf()
    {
        return overwriteGraphConf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOverwriteGraphConf(boolean newOverwriteGraphConf)
    {
        boolean oldOverwriteGraphConf = overwriteGraphConf;
        overwriteGraphConf = newOverwriteGraphConf;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF, oldOverwriteGraphConf, overwriteGraphConf));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isOrganizeImports()
    {
        return organizeImports;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOrganizeImports(boolean newOrganizeImports)
    {
        boolean oldOrganizeImports = organizeImports;
        organizeImports = newOrganizeImports;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS, oldOrganizeImports, organizeImports));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EditorConfiguration getEditorConfigurator()
    {
        if (editorConfigurator != null && editorConfigurator.eIsProxy())
        {
            InternalEObject oldEditorConfigurator = (InternalEObject)editorConfigurator;
            editorConfigurator = (EditorConfiguration)eResolveProxy(oldEditorConfigurator);
            if (editorConfigurator != oldEditorConfigurator)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR, oldEditorConfigurator, editorConfigurator));
            }
        }
        return editorConfigurator;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EditorConfiguration basicGetEditorConfigurator()
    {
        return editorConfigurator;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setEditorConfigurator(EditorConfiguration newEditorConfigurator)
    {
        EditorConfiguration oldEditorConfigurator = editorConfigurator;
        editorConfigurator = newEditorConfigurator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR, oldEditorConfigurator, editorConfigurator));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getCopyrightText()
    {
        return copyrightText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setCopyrightText(String newCopyrightText)
    {
        String oldCopyrightText = copyrightText;
        copyrightText = newCopyrightText;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT, oldCopyrightText, copyrightText));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getPluginVersion()
    {
        return pluginVersion;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPluginVersion(String newPluginVersion)
    {
        String oldPluginVersion = pluginVersion;
        pluginVersion = newPluginVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION, oldPluginVersion, pluginVersion));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getProvider()
    {
        return provider;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setProvider(String newProvider)
    {
        String oldProvider = provider;
        provider = newProvider;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER, oldProvider, provider));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isSamePluginAsEditor()
    {
        return samePluginAsEditor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSamePluginAsEditor(boolean newSamePluginAsEditor)
    {
        boolean oldSamePluginAsEditor = samePluginAsEditor;
        samePluginAsEditor = newSamePluginAsEditor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR, oldSamePluginAsEditor, samePluginAsEditor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getBasePackage()
    {
        if (isSamePluginAsEditor())
        {
            return getProjectName().concat(".").concat(getPackage());
        }

        return getProjectName();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                return basicSetPalette(null, msgs);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
                return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME:
                return getProjectName();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                return getName();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                return getPackage();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                return getPrefix();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                return getPalette();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                return getParts();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                return getLayout();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
                return getObjects();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL:
                if (resolve) return getGenModel();
                return basicGetGenModel();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return getDefaultBackgroundColor();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT:
                return getDefaultFont();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT:
                if (resolve) return getTemplateRootObject();
                return basicGetTemplateRootObject();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE:
                return isForceOverwrite() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF:
                return isOverwriteGraphConf() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS:
                return isOrganizeImports() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR:
                if (resolve) return getEditorConfigurator();
                return basicGetEditorConfigurator();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT:
                return getCopyrightText();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION:
                return getPluginVersion();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER:
                return getProvider();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR:
                return isSamePluginAsEditor() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME:
                setProjectName((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                setName((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                setPackage((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                setPrefix((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                setPalette((PaletteConfiguration)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                getParts().clear();
                getParts().addAll((Collection<? extends PartConfiguration>)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                setLayout((LayoutType)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
                getObjects().clear();
                getObjects().addAll((Collection<? extends ObjectConfiguration>)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor((Color)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((Color)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT:
                setDefaultFont((Font)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT:
                setTemplateRootObject((GenClass)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE:
                setForceOverwrite(((Boolean)newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF:
                setOverwriteGraphConf(((Boolean)newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS:
                setOrganizeImports(((Boolean)newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR:
                setEditorConfigurator((EditorConfiguration)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT:
                setCopyrightText((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER:
                setProvider((String)newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR:
                setSamePluginAsEditor(((Boolean)newValue).booleanValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME:
                setProjectName(PROJECT_NAME_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                setPackage(PACKAGE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                setPrefix(PREFIX_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                setPalette((PaletteConfiguration)null);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                getParts().clear();
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                setLayout(LAYOUT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
                getObjects().clear();
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel)null);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT:
                setDefaultFont(DEFAULT_FONT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT:
                setTemplateRootObject((GenClass)null);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE:
                setForceOverwrite(FORCE_OVERWRITE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF:
                setOverwriteGraphConf(OVERWRITE_GRAPH_CONF_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS:
                setOrganizeImports(ORGANIZE_IMPORTS_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR:
                setEditorConfigurator((EditorConfiguration)null);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT:
                setCopyrightText(COPYRIGHT_TEXT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion(PLUGIN_VERSION_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER:
                setProvider(PROVIDER_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR:
                setSamePluginAsEditor(SAME_PLUGIN_AS_EDITOR_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME:
                return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                return palette != null;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                return parts != null && !parts.isEmpty();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                return layout != LAYOUT_EDEFAULT;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
                return objects != null && !objects.isEmpty();
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL:
                return genModel != null;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return DEFAULT_BACKGROUND_COLOR_EDEFAULT == null ? defaultBackgroundColor != null : !DEFAULT_BACKGROUND_COLOR_EDEFAULT.equals(defaultBackgroundColor);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT:
                return DEFAULT_FONT_EDEFAULT == null ? defaultFont != null : !DEFAULT_FONT_EDEFAULT.equals(defaultFont);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT:
                return templateRootObject != null;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE:
                return forceOverwrite != FORCE_OVERWRITE_EDEFAULT;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF:
                return overwriteGraphConf != OVERWRITE_GRAPH_CONF_EDEFAULT;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS:
                return organizeImports != ORGANIZE_IMPORTS_EDEFAULT;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR:
                return editorConfigurator != null;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT:
                return COPYRIGHT_TEXT_EDEFAULT == null ? copyrightText != null : !COPYRIGHT_TEXT_EDEFAULT.equals(copyrightText);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION:
                return PLUGIN_VERSION_EDEFAULT == null ? pluginVersion != null : !PLUGIN_VERSION_EDEFAULT.equals(pluginVersion);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER:
                return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR:
                return samePluginAsEditor != SAME_PLUGIN_AS_EDITOR_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (projectName: ");
        result.append(projectName);
        result.append(", name: ");
        result.append(name);
        result.append(", package: ");
        result.append(package_);
        result.append(", prefix: ");
        result.append(prefix);
        result.append(", layout: ");
        result.append(layout);
        result.append(", defaultBackgroundColor: ");
        result.append(defaultBackgroundColor);
        result.append(", defaultForegroundColor: ");
        result.append(defaultForegroundColor);
        result.append(", defaultFont: ");
        result.append(defaultFont);
        result.append(", forceOverwrite: ");
        result.append(forceOverwrite);
        result.append(", overwriteGraphConf: ");
        result.append(overwriteGraphConf);
        result.append(", organizeImports: ");
        result.append(organizeImports);
        result.append(", copyrightText: ");
        result.append(copyrightText);
        result.append(", pluginVersion: ");
        result.append(pluginVersion);
        result.append(", provider: ");
        result.append(provider);
        result.append(", samePluginAsEditor: ");
        result.append(samePluginAsEditor);
        result.append(')');
        return result.toString();
    }

    // ---
    // ------
    // ---------
    // ------------
    // CODE CUSTOM
    // ------------
    // ---------
    // ------
    // ---

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPluginPrefix()
     */
    public String getPluginPrefix()
    {
        if (isSamePluginAsEditor())
        {
            return getEditorConfigurator().getPrefix();
        }

        return getPrefix();
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getJavaCopyrightText()
     */
    public String getJavaCopyrightText()
    {
        final String LINE_SEPARATOR = String.valueOf((char) Character.LETTER_NUMBER);

        String start = "/*******************************************************************************";
        String end = " ******************************************************************************/";
        String result = "";

        String[] copyrightLines = getCopyrightText() == null ? new String[] {"No CopyrightText Defined in the configurator file."} : getCopyrightText().split(LINE_SEPARATOR);
        result = result.concat(start).concat(LINE_SEPARATOR);
        for (int cpt = 0; cpt < copyrightLines.length; cpt++)
        {
            result = result.concat(" * ").concat(copyrightLines[cpt]).concat(LINE_SEPARATOR);
        }
        result = result.concat(end);
        return result;
    }

    // -------------------------------------------------------------
    // These methods ensure compatibility with the old configurator
    // -------------------------------------------------------------

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getExtension()
     */
    public String getExtension()
    {
        return ((GenPackage) getGenModel().getGenPackages().get(0)).getPrefix().toLowerCase();
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getExtensionDiagram()
     */
    public String getExtensionDiagram()
    {
        return getExtension().concat("di");
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getGraphConfIPath()
     */
    public String getGraphConfIPath()
    {
        return getBasePackage().replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + "diagram.graphconf";
    }

    // ------------------------------------------------------------
    // Utilities methods. These methods are used in the templates.
    // ------------------------------------------------------------

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getUniqueModelObjectConfList(boolean, boolean)
     */
    public List<ModelObjectConfiguration> getUniqueModelObjectConfList(boolean nodeFilter, boolean edgeFilter)
    {
        List<ModelObjectConfiguration> resultList = new ArrayList<ModelObjectConfiguration>();
        for (PartConfiguration partConf : getParts())
        {
            if (((nodeFilter && partConf instanceof NodePartConfiguration) || (edgeFilter && partConf instanceof EdgePartConfiguration)) && partConf.getObject() instanceof ModelObjectConfiguration)
            {
                ModelObjectConfiguration objConf = (ModelObjectConfiguration) partConf.getObject();
                if (!resultList.contains(objConf))
                {
                    resultList.add(objConf);
                }
            }
        }
        return resultList;
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getUniqueModelObjectConfListFromPalette(boolean,
     *      boolean)
     */
    public List<ModelObjectConfiguration> getUniqueModelObjectConfListFromPalette(boolean nodeFilter, boolean edgeFilter)
    {
        List<ModelObjectConfiguration> resultList = new ArrayList<ModelObjectConfiguration>();

        for (PaletteCategory paletteCategory : getPalette().getPaletteCategories())
        {
            for (PaletteItem palItem : paletteCategory.getItems())
            {
                if (((nodeFilter && palItem.getPart() instanceof NodePartConfiguration) || (edgeFilter && palItem.getPart() instanceof EdgePartConfiguration))
                        && palItem.getPart().getObject() instanceof ModelObjectConfiguration)
                {
                    ModelObjectConfiguration objConf = (ModelObjectConfiguration) palItem.getPart().getObject();
                    if (!resultList.contains(objConf))
                    {
                        resultList.add(objConf);
                    }
                }
            }
        }
        return resultList;
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultBackgroundColorStringValue()
     */
    public String getDefaultBackgroundColorStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getColor(), getDefaultBackgroundColor());
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultForegroundColorStringValue()
     */
    public String getDefaultForegroundColorStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getColor(), getDefaultForegroundColor());
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultFontStringValue()
     */
    public String getDefaultFontStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getFont(), getDefaultFont());
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPartActions()
     */
    public List<PartAction> getPartActions()
    {
        List<PartAction> partActionList = new ArrayList<PartAction>();

        for (PartConfiguration partConf : getParts())
        {
            partActionList.addAll(partConf.getActions());
        }

        return partActionList;
    }

} // DiagramConfigurationImpl
