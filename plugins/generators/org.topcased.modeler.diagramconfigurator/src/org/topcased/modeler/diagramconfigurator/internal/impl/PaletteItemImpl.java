/**
 * <copyright>
 * </copyright>
 *
 * $Id: PaletteItemImpl.java,v 1.4 2007/04/18 12:21:14 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.PaletteItem;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Palette Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PaletteItemImpl extends EModelElementImpl implements PaletteItem
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
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
     * The cached value of the '{@link #getPart() <em>Part</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPart()
     * @generated
     * @ordered
     */
    protected PartConfiguration part;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PaletteItemImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramconfiguratorPackage.Literals.PALETTE_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PALETTE_ITEM__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration getPart()
    {
        if (part != null && part.eIsProxy())
        {
            InternalEObject oldPart = (InternalEObject) part;
            part = (PartConfiguration) eResolveProxy(oldPart);
            if (part != oldPart)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.PALETTE_ITEM__PART, oldPart, part));
            }
        }
        return part;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration basicGetPart()
    {
        return part;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPart(PartConfiguration newPart)
    {
        PartConfiguration oldPart = part;
        part = newPart;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PALETTE_ITEM__PART, oldPart, part));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PALETTE_ITEM__NAME:
                return getName();
            case DiagramconfiguratorPackage.PALETTE_ITEM__PART:
                if (resolve)
                    return getPart();
                return basicGetPart();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PALETTE_ITEM__NAME:
                setName((String) newValue);
                return;
            case DiagramconfiguratorPackage.PALETTE_ITEM__PART:
                setPart((PartConfiguration) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PALETTE_ITEM__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PALETTE_ITEM__PART:
                setPart((PartConfiguration) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PALETTE_ITEM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DiagramconfiguratorPackage.PALETTE_ITEM__PART:
                return part != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

    // -----------------------------------------
    // Utilities methods used in the templates.
    // -----------------------------------------

    public String getCodeCustom(String key)
    {
        String codeToInsert = null;

        if (getEAnnotation("codeCustom") != null)
        {
            EAnnotation eAnnotation = getEAnnotation("codeCustom");
            if (eAnnotation.getDetails().containsKey(key))
            {
                codeToInsert = (String) eAnnotation.getDetails().get(key);
            }
        }

        return codeToInsert;
    }

} // PaletteItemImpl
