/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramGraphConf.java,v 1.4 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getNode <em>Node</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getEdge <em>Edge</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultFont <em>Default Font</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf()
 * @model annotation="http://www.topcased.org/documentation documentation='A DiagramGraphConf is associated with a
 *        DiagramConfiguration. It contains informations on the graphical representation of the diagram associated.'"
 * @generated
 */
public interface DiagramGraphConf extends EObject
{
    /**
     * Returns the value of the '<em><b>Node</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.graphconf.NodeGraphConf}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Node</em>' containment reference list.
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_Node()
     * @model type="org.topcased.modeler.graphconf.NodeGraphConf" containment="true"
     * @generated
     */
    EList getNode();

    /**
     * Returns the value of the '<em><b>Edge</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.graphconf.EdgeGraphConf}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Edge</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Edge</em>' containment reference list.
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_Edge()
     * @model type="org.topcased.modeler.graphconf.EdgeGraphConf" containment="true"
     * @generated
     */
    EList getEdge();

    /**
     * Returns the value of the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Background Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Background Color</em>' attribute.
     * @see #setDefaultBackgroundColor(Color)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_DefaultBackgroundColor()
     * @model dataType="org.topcased.modeler.graphconf.Color"
     * @generated
     */
    Color getDefaultBackgroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Background Color</em>' attribute.
     * @see #getDefaultBackgroundColor()
     * @generated
     */
    void setDefaultBackgroundColor(Color value);

    /**
     * Returns the value of the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Foreground Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Foreground Color</em>' attribute.
     * @see #setDefaultForegroundColor(Color)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_DefaultForegroundColor()
     * @model dataType="org.topcased.modeler.graphconf.Color"
     * @generated
     */
    Color getDefaultForegroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Foreground Color</em>' attribute.
     * @see #getDefaultForegroundColor()
     * @generated
     */
    void setDefaultForegroundColor(Color value);

    /**
     * Returns the value of the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Font</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Font</em>' attribute.
     * @see #setDefaultFont(Font)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_DefaultFont()
     * @model dataType="org.topcased.modeler.graphconf.Font"
     * @generated
     */
    Font getDefaultFont();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultFont <em>Default Font</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Font</em>' attribute.
     * @see #getDefaultFont()
     * @generated
     */
    void setDefaultFont(Font value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getDiagramGraphConf_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Get the NodeGraphConf associated with the given id
     * 
     * @param typeEClass the EClass model object associated withe the NodeGraphConf
     * @param presentation the presentation of the NodeGraphConf
     * @return the NodeGraphConf or null if not found
     */
    NodeGraphConf getNodeGraphConf(EClass typeEClass, String presentation);

    /**
     * Get the List of NodeGraphConf associated with the given presentation
     * 
     * @param typeEClass the EClass model object associated withe the NodeGraphConf
     * @param presentation the presentation of the NodeGraphConf
     * @return the list of all the nodes. An empty list is returned when no node were found.
     */
    List getListNodeGraphConf(EClass typeEClass, String presentation);

    /**
     * Get the NodeGraphConf associated with the given id
     * 
     * @param type the type of the NodeGraphConf (the typeInfo property of the DI)
     * @param presentation the presentation of the NodeGraphConf
     * @return the NodeGraphConf or null if not found
     */
    NodeGraphConf getNodeGraphConf(String type, String presentation);

    /**
     * Get the EdgeGraphConf associated with the given id
     * 
     * @param typeEClass the EClass model object associated withe the EdgeGraphConf
     * @param presentation the presentation of the EdgeGraphConf
     * @return the EdgeGraphConf or null if not found
     */
    EdgeGraphConf getEdgeGraphConf(EClass typeEClass, String presentation);

    /**
     * Get the List of EdgeGraphConf associated with the given presentation
     * 
     * @param typeEClass the EClass model object associated withe the EdgeGraphConf
     * @param presentation the presentation of the EdgeGraphConf
     * @return the list of all the edges. An empty list is returned when no edge were found.
     */
    List getListEdgeGraphConf(EClass typeEClass, String presentation);

    /**
     * Get the EdgeGraphConf associated with the given id
     * 
     * @param type the type of the EdgeGraphConf (the typeInfo property of the DI)
     * @param presentation the presentation of the EdgeGraphConf
     * @return the EdgeGraphConf or null if not found
     */
    EdgeGraphConf getEdgeGraphConf(String type, String presentation);

} // DiagramGraphConf
