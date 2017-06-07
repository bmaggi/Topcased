/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsPackage.java,v 1.9 2007/04/12 08:32:17 jako Exp $
 */
package org.topcased.modeler.diagrams.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.diagrams.model.DiagramsFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramsPackage extends EPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "";

    /**
     * The package name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/Diagrams/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "diagrams";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    DiagramsPackage eINSTANCE = org.topcased.modeler.diagrams.model.internal.impl.DiagramsPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl <em>Diagrams</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl
     * @see org.topcased.modeler.diagrams.model.internal.impl.DiagramsPackageImpl#getDiagrams()
     * @generated
     */
    int DIAGRAMS = 0;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAMS__MODEL = 0;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAMS__DIAGRAMS = 1;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAMS__ACTIVE_DIAGRAM = 2;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAMS__SUBDIAGRAMS = 3;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAMS__PARENT = 4;

    /**
     * The number of structural features of the '<em>Diagrams</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAMS_FEATURE_COUNT = 5;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagrams.model.Diagrams <em>Diagrams</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagrams</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams
     * @generated
     */
    EClass getDiagrams();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagrams.model.Diagrams#getModel <em>Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Model</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams#getModel()
     * @see #getDiagrams()
     * @generated
     */
    EReference getDiagrams_Model();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagrams.model.Diagrams#getDiagrams <em>Diagrams</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Diagrams</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams#getDiagrams()
     * @see #getDiagrams()
     * @generated
     */
    EReference getDiagrams_Diagrams();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagrams.model.Diagrams#getActiveDiagram <em>Active Diagram</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Active Diagram</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams#getActiveDiagram()
     * @see #getDiagrams()
     * @generated
     */
    EReference getDiagrams_ActiveDiagram();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagrams.model.Diagrams#getSubdiagrams <em>Subdiagrams</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Subdiagrams</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams#getSubdiagrams()
     * @see #getDiagrams()
     * @generated
     */
    EReference getDiagrams_Subdiagrams();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.modeler.diagrams.model.Diagrams#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see org.topcased.modeler.diagrams.model.Diagrams#getParent()
     * @see #getDiagrams()
     * @generated
     */
    EReference getDiagrams_Parent();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DiagramsFactory getDiagramsFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl <em>Diagrams</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl
         * @see org.topcased.modeler.diagrams.model.internal.impl.DiagramsPackageImpl#getDiagrams()
         * @generated
         */
        EClass DIAGRAMS = eINSTANCE.getDiagrams();

        /**
         * The meta object literal for the '<em><b>Model</b></em>' reference feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EReference DIAGRAMS__MODEL = eINSTANCE.getDiagrams_Model();

        /**
         * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAMS__DIAGRAMS = eINSTANCE.getDiagrams_Diagrams();

        /**
         * The meta object literal for the '<em><b>Active Diagram</b></em>' reference feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EReference DIAGRAMS__ACTIVE_DIAGRAM = eINSTANCE.getDiagrams_ActiveDiagram();

        /**
         * The meta object literal for the '<em><b>Subdiagrams</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAMS__SUBDIAGRAMS = eINSTANCE.getDiagrams_Subdiagrams();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAMS__PARENT = eINSTANCE.getDiagrams_Parent();

    }

} // DiagramsPackage
