/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramGraphConfImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.graphconf.StringBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getNode <em>Node</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getEdge <em>Edge</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl#getDefaultFont <em>Default Font</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramGraphConfImpl extends EObjectImpl implements DiagramGraphConf
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getNode()
     * @generated
     * @ordered
     */
    protected EList node = null;

    /**
     * The cached value of the '{@link #getEdge() <em>Edge</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getEdge()
     * @generated
     * @ordered
     */
    protected EList edge = null;

    /**
     * The default value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_BACKGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultBackgroundColor = DEFAULT_BACKGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_FOREGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultForegroundColor = DEFAULT_FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected static final Font DEFAULT_FONT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected Font defaultFont = DEFAULT_FONT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DiagramGraphConfImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass()
    {
        return GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getId()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(String newId)
    {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.DIAGRAM_GRAPH_CONF__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getNode()
    {
        if (node == null)
        {
            node = new EObjectContainmentEList(NodeGraphConf.class, this, GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE);
        }
        return node;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getEdge()
    {
        if (edge == null)
        {
            edge = new EObjectContainmentEList(EdgeGraphConf.class, this, GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE);
        }
        return edge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Color getDefaultBackgroundColor()
    {
        return defaultBackgroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultBackgroundColor(Color newDefaultBackgroundColor)
    {
        Color oldDefaultBackgroundColor = defaultBackgroundColor;
        defaultBackgroundColor = newDefaultBackgroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR, oldDefaultBackgroundColor, defaultBackgroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Color getDefaultForegroundColor()
    {
        return defaultForegroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultForegroundColor(Color newDefaultForegroundColor)
    {
        Color oldDefaultForegroundColor = defaultForegroundColor;
        defaultForegroundColor = newDefaultForegroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR, oldDefaultForegroundColor, defaultForegroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Font getDefaultFont()
    {
        return defaultFont;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultFont(Font newDefaultFont)
    {
        Font oldDefaultFont = defaultFont;
        defaultFont = newDefaultFont;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT, oldDefaultFont, defaultFont));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
                return ((InternalEList) getNode()).basicRemove(otherEnd, msgs);
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                return ((InternalEList) getEdge()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__ID:
                return getId();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
                return getNode();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                return getEdge();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                return getDefaultBackgroundColor();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT:
                return getDefaultFont();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__ID:
                setId((String) newValue);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
                getNode().clear();
                getNode().addAll((Collection) newValue);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                getEdge().clear();
                getEdge().addAll((Collection) newValue);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor((Color) newValue);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((Color) newValue);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT:
                setDefaultFont((Font) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__ID:
                setId(ID_EDEFAULT);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
                getNode().clear();
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                getEdge().clear();
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR_EDEFAULT);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT:
                setDefaultFont(DEFAULT_FONT_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
                return node != null && !node.isEmpty();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                return edge != null && !edge.isEmpty();
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                return DEFAULT_BACKGROUND_COLOR_EDEFAULT == null ? defaultBackgroundColor != null : !DEFAULT_BACKGROUND_COLOR_EDEFAULT.equals(defaultBackgroundColor);
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT:
                return DEFAULT_FONT_EDEFAULT == null ? defaultFont != null : !DEFAULT_FONT_EDEFAULT.equals(defaultFont);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", defaultBackgroundColor: ");
        result.append(defaultBackgroundColor);
        result.append(", defaultForegroundColor: ");
        result.append(defaultForegroundColor);
        result.append(", defaultFont: ");
        result.append(defaultFont);
        result.append(')');
        return result.toString();
    }

    // ===
    // ======
    // =========
    // ============
    // CUSTOM CODE
    // ============
    // =========
    // ======
    // ===

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getNodeGraphConf(org.eclipse.emf.ecore.EClass,
     *      java.lang.String)
     */
    public NodeGraphConf getNodeGraphConf(EClass typeEClass, String presentation)
    {
        Iterator itNodes = this.getNode().iterator();
        while (itNodes.hasNext())
        {
            NodeGraphConf currentNode = (NodeGraphConf) itNodes.next();
            if (currentNode.getBridge() instanceof EMFBridge && typeEClass.equals(((EMFBridge) currentNode.getBridge()).getType()) && presentation.equals(currentNode.getPresentation()))
            {
                return currentNode;
            }
        }

        NodeGraphConf superTypeNodeGraphConf = null;
        for (int i = 0; i < typeEClass.getESuperTypes().size() && superTypeNodeGraphConf == null; i++)
        {
            superTypeNodeGraphConf = getNodeGraphConf((EClass) typeEClass.getESuperTypes().get(i), presentation);
        }
        return superTypeNodeGraphConf;
    }

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getListNodeGraphConf(org.eclipse.emf.ecore.EClass,
     *      java.lang.String)
     */
    public List getListNodeGraphConf(EClass typeEClass, String presentation)
    {
        List allNodes = new ArrayList();

        // Compatibility with old diagram files where the presentation was not set
        presentation = presentation == null ? "default" : presentation;

        Iterator itNodes = this.getNode().iterator();
        while (itNodes.hasNext())
        {
            NodeGraphConf currentNode = (NodeGraphConf) itNodes.next();
            if (currentNode.getBridge() instanceof EMFBridge && typeEClass.equals(((EMFBridge) currentNode.getBridge()).getType()) && presentation.equals(currentNode.getPresentation()))
            {
                allNodes.add(currentNode);
            }
        }

        return allNodes;
    }

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getNodeGraphConf(java.lang.String, java.lang.String)
     */
    public NodeGraphConf getNodeGraphConf(String type, String presentation)
    {
        Iterator itNodes = this.getNode().iterator();
        while (itNodes.hasNext())
        {
            NodeGraphConf currentNode = (NodeGraphConf) itNodes.next();
            if (currentNode.getBridge() instanceof StringBridge && type.equals(((StringBridge) currentNode.getBridge()).getType()) && presentation.equals(currentNode.getPresentation()))
            {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getEdgeGraphConf(org.eclipse.emf.ecore.EClass,
     *      java.lang.String)
     */
    public EdgeGraphConf getEdgeGraphConf(EClass typeEClass, String presentation)
    {
        Iterator itEdges = this.getEdge().iterator();
        while (itEdges.hasNext())
        {
            EdgeGraphConf currentEdge = (EdgeGraphConf) itEdges.next();
            if (currentEdge.getBridge() instanceof EMFBridge && typeEClass.equals(((EMFBridge) currentEdge.getBridge()).getType()) && presentation.equals(currentEdge.getPresentation()))
            {
                // if (typetypeEClass.getClassifierID() == ((EMFBridge)
                // currentEdge.getBridge()).getType().getClassifierID())
                // {
                // return null;
                // }
                return currentEdge;
            }
        }

        EdgeGraphConf superTypeEdgeGraphConf = null;
        for (int i = 0; i < typeEClass.getESuperTypes().size() && superTypeEdgeGraphConf == null; i++)
        {
            superTypeEdgeGraphConf = getEdgeGraphConf((EClass) typeEClass.getESuperTypes().get(i), presentation);
        }
        return superTypeEdgeGraphConf;
    }

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getListEdgeGraphConf(org.eclipse.emf.ecore.EClass,
     *      java.lang.String)
     */
    public List getListEdgeGraphConf(EClass typeEClass, String presentation)
    {
        List allEdges = new ArrayList();

        Iterator itEdges = this.getEdge().iterator();
        while (itEdges.hasNext())
        {
            EdgeGraphConf currentEdge = (EdgeGraphConf) itEdges.next();
            if (currentEdge.getBridge() instanceof EMFBridge && typeEClass.equals(((EMFBridge) currentEdge.getBridge()).getType()) && presentation.equals(currentEdge.getPresentation()))
            {
                allEdges.add(currentEdge);
            }
        }

        return allEdges;
    }

    /**
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getEdgeGraphConf(java.lang.String, java.lang.String)
     */
    public EdgeGraphConf getEdgeGraphConf(String type, String presentation)
    {
        Iterator itEdges = this.getEdge().iterator();
        while (itEdges.hasNext())
        {
            EdgeGraphConf currentEdge = (EdgeGraphConf) itEdges.next();
            if (currentEdge.getBridge() instanceof StringBridge && type.equals(((StringBridge) currentEdge.getBridge()).getType()) && presentation.equals(currentEdge.getPresentation()))
            {
                return currentEdge;
            }
        }
        return null;
    }

} // DiagramGraphConfImpl
