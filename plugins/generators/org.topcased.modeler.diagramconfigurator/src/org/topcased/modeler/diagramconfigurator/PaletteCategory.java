/**
 * <copyright>
 * </copyright>
 *
 * $Id: PaletteCategory.java,v 1.9 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Palette Category</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteCategory#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteCategory#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteCategory()
 * @model annotation="http://www.topcased.org/documentation documentation='A PaletteCategory contains all the
 *        PaletteItem that will be displayed'" annotation="http://www.eclipse.org/emf/2002/Ecore constraints='Name
 *        PaletteItemsNameUnicity'"
 * @generated
 */
public interface PaletteCategory extends EObject
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteCategory_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PaletteCategory#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.diagramconfigurator.PaletteItem}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteCategory_Items()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PaletteItem> getItems();

} // PaletteCategory
