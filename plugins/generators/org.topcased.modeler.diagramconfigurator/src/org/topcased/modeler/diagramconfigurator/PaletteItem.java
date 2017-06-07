/**
 * <copyright> </copyright>
 * 
 * $Id: PaletteItem.java,v 1.8 2007/04/18 12:21:03 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Palette Item</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteItem()
 * @model annotation="http://www.topcased.org/documentation documentation='A PaletteItem is necessary associated with an
 *        ObjectConfiguration. It will represent an item in a Palette of a given Diagram'"
 * @generated
 */
public interface PaletteItem extends EModelElement
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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteItem_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Part</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Part</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Part</em>' reference.
     * @see #setPart(PartConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteItem_Part()
     * @model required="true"
     * @generated
     */
    PartConfiguration getPart();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getPart <em>Part</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Part</em>' reference.
     * @see #getPart()
     * @generated
     */
    void setPart(PartConfiguration value);

    // -----------------------------------------
    // Utilities methods used in the templates.
    // -----------------------------------------

    /**
     * Get the value of the Detail Entry that correspond to the given key. This Detail Entry is searched in the first
     * EAnnotation used to add code customization.
     * 
     * @param key define the type of code customization
     * @return the snippet of code to insert
     */
    public String getCodeCustom(String key);

} // PaletteItem
