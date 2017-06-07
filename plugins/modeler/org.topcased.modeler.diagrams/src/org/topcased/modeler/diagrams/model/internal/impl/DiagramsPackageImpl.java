/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsPackageImpl.java,v 1.3 2007/04/12 08:32:13 jako Exp $
 */
package org.topcased.modeler.diagrams.model.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.DiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class DiagramsPackageImpl extends EPackageImpl implements DiagramsPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramsEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DiagramsPackageImpl()
    {
        super(eNS_URI, DiagramsFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DiagramsPackage init()
    {
        if (isInited) return (DiagramsPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramsPackage.eNS_URI);

        // Obtain or create and register package
        DiagramsPackageImpl theDiagramsPackage = (DiagramsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DiagramsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DiagramsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DiagramInterchangePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDiagramsPackage.createPackageContents();

        // Initialize created meta-data
        theDiagramsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDiagramsPackage.freeze();

        return theDiagramsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagrams()
    {
        return diagramsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagrams_Model()
    {
        return (EReference)diagramsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagrams_Diagrams()
    {
        return (EReference)diagramsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagrams_ActiveDiagram()
    {
        return (EReference)diagramsEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagrams_Subdiagrams()
    {
        return (EReference)diagramsEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagrams_Parent()
    {
        return (EReference)diagramsEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramsFactory getDiagramsFactory()
    {
        return (DiagramsFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        diagramsEClass = createEClass(DIAGRAMS);
        createEReference(diagramsEClass, DIAGRAMS__MODEL);
        createEReference(diagramsEClass, DIAGRAMS__DIAGRAMS);
        createEReference(diagramsEClass, DIAGRAMS__ACTIVE_DIAGRAM);
        createEReference(diagramsEClass, DIAGRAMS__SUBDIAGRAMS);
        createEReference(diagramsEClass, DIAGRAMS__PARENT);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        DiagramInterchangePackage theDiagramInterchangePackage = (DiagramInterchangePackage)EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(diagramsEClass, Diagrams.class, "Diagrams", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDiagrams_Model(), ecorePackage.getEObject(), null, "model", null, 1, 1, Diagrams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagrams_Diagrams(), theDiagramInterchangePackage.getDiagram(), null, "diagrams", null, 0, -1, Diagrams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDiagrams_ActiveDiagram(), theDiagramInterchangePackage.getDiagram(), null, "activeDiagram", null, 0, 1, Diagrams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagrams_Subdiagrams(), this.getDiagrams(), this.getDiagrams_Parent(), "subdiagrams", null, 0, -1, Diagrams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDiagrams_Parent(), this.getDiagrams(), this.getDiagrams_Subdiagrams(), "parent", null, 0, 1, Diagrams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // DiagramsPackageImpl
