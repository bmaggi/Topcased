/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImageImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Image;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Image</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.ImageImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.ImageImpl#getMimeType <em>Mime Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageImpl extends LeafElementImpl implements Image
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected String uri = URI_EDEFAULT;

    /**
     * The default value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getMimeType()
     * @generated
     * @ordered
     */
    protected static final String MIME_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getMimeType()
     * @generated
     * @ordered
     */
    protected String mimeType = MIME_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ImageImpl()
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
        return DiagramInterchangePackage.Literals.IMAGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getUri()
    {
        return uri;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setUri(String newUri)
    {
        String oldUri = uri;
        uri = newUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.IMAGE__URI, oldUri, uri));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setMimeType(String newMimeType)
    {
        String oldMimeType = mimeType;
        mimeType = newMimeType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.IMAGE__MIME_TYPE, oldMimeType, mimeType));
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
            case DiagramInterchangePackage.IMAGE__URI:
                return getUri();
            case DiagramInterchangePackage.IMAGE__MIME_TYPE:
                return getMimeType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.IMAGE__URI:
                setUri((String) newValue);
                return;
            case DiagramInterchangePackage.IMAGE__MIME_TYPE:
                setMimeType((String) newValue);
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
            case DiagramInterchangePackage.IMAGE__URI:
                setUri(URI_EDEFAULT);
                return;
            case DiagramInterchangePackage.IMAGE__MIME_TYPE:
                setMimeType(MIME_TYPE_EDEFAULT);
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
            case DiagramInterchangePackage.IMAGE__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
            case DiagramInterchangePackage.IMAGE__MIME_TYPE:
                return MIME_TYPE_EDEFAULT == null ? mimeType != null : !MIME_TYPE_EDEFAULT.equals(mimeType);
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
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (uri: "); //$NON-NLS-1$
        result.append(uri);
        result.append(", mimeType: "); //$NON-NLS-1$
        result.append(mimeType);
        result.append(')');
        return result.toString();
    }

} // ImageImpl
