/**
 * <copyright>
 * </copyright>
 *
 * $Id: SourceTargetCoupleItemProvider.java,v 1.7 2006/01/10 16:32:14 jako Exp $
 */
package org.topcased.modeler.configurator.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.EdgeContainerType;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.SourceTargetCouple;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.configurator.SourceTargetCouple} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceTargetCoupleItemProvider
    extends ItemProviderAdapter
    implements	
        IEditingDomainItemProvider,	
        IStructuredItemContentProvider,	
        ITreeItemContentProvider,	
        IItemLabelProvider,	
        IItemPropertySource		
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceTargetCoupleItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addContainerTypePropertyDescriptor(object);
            addAutoRefPropertyDescriptor(object);
            addReversiblePropertyDescriptor(object);
            addContainerObjectPropertyDescriptor(object);
            addSourceNodePropertyDescriptor(object);
            addTargetNodePropertyDescriptor(object);
            addContainerRefPropertyDescriptor(object);
            addRefSourceToEdgePropertyDescriptor(object);
            addRefEdgeToSourcePropertyDescriptor(object);
            addRefTargetToEdgePropertyDescriptor(object);
            addRefEdgeToTargetPropertyDescriptor(object);
            addRefSourceToTargetPropertyDescriptor(object);
            addRefTargetToSourcePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Container Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addContainerTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_containerType_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_containerType_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_ContainerType(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Auto Ref feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAutoRefPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_autoRef_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_autoRef_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_AutoRef(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Reversible feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addReversiblePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_reversible_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_reversible_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_Reversible(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Container Object feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addContainerObjectPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_containerObject_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_containerObject_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_ContainerObject(),
                 true,
                 null,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Source Node feature.
     * <!-- begin-user-doc -->
     * Display only the NodePartConfiguration of the current diagram
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addSourceNodePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_sourceNode_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_sourceNode_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_SourceNode(),
                 true,
                 null,
                 getString("_UI_GraphicConnectionPropertyCategory"), //$NON-NLS-1$
                 null)
        {
            protected Collection getComboBoxObjects(Object obj)
            {
                List result = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) obj;
                EList parts = ((DiagramConfiguration) couple.eContainer().eContainer()).getParts();
                for (Iterator iter = parts.iterator(); iter.hasNext();)
                {
                    PartConfiguration partConf = (PartConfiguration) iter.next();
                    if (partConf instanceof NodePartConfiguration)
                    {
                        result.add(partConf);
                    }
                }
                return result;
            }
        });
    }

    /**
     * This adds a property descriptor for the Target Node feature.
     * <!-- begin-user-doc -->
     * Display only the NodePartConfiguration of the current diagram
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addTargetNodePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SourceTargetCouple_targetNode_feature"), //$NON-NLS-1$
                 getString("_UI_SourceTargetCouple_targetNode_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_TargetNode(),
                 true,
                 null,
                 getString("_UI_GraphicConnectionPropertyCategory"), //$NON-NLS-1$
                 null)
        {
            protected Collection getComboBoxObjects(Object obj)
            {
                List result = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) obj;
                EList parts = ((DiagramConfiguration) couple.eContainer().eContainer()).getParts();
                for (Iterator iter = parts.iterator(); iter.hasNext();)
                {
                    PartConfiguration partConf = (PartConfiguration) iter.next();
                    if (partConf instanceof NodePartConfiguration)
                    {
                        result.add(partConf);
                    }
                }
                return result;
            }
        });                 
    }

    /**
     * This adds a property descriptor for the Container Ref feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addContainerRefPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_containerRef_feature"),
                getString("_UI_SourceTargetCouple_containerRef_description"),
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_ContainerRef(),
                true, null, getString("_UI_ModelPropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;

                EdgeContainerType type = couple.getContainerType();
                switch (type.getValue())
                {
                    case EdgeContainerType.NONE:
                        break;
                    case EdgeContainerType.SOURCE:
                        if (couple.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                        {
                            containments.addAll(((ModelObjectConfiguration) couple.getSourceNode().getObject()).getGenClass().getEcoreClass().getEAllContainments());
                        }
                        break;
                    case EdgeContainerType.TARGET:
                        if (couple.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                        {
                            containments.addAll(((ModelObjectConfiguration) couple.getTargetNode().getObject()).getGenClass().getEcoreClass().getEAllContainments());
                        }
                        break;
                    case EdgeContainerType.DIAGRAM:
                    case EdgeContainerType.SOURCE_CONTAINER:
                    case EdgeContainerType.TARGET_CONTAINER:
                    default:
                        if (couple.getContainerObject() != null)
                        {
                            containments.addAll(couple.getContainerObject().getEcoreClass().getEAllContainments());
                        }
                        break;
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Ref Source To Edge feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefSourceToEdgePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refSourceToEdge_feature"), //$NON-NLS-1$
                getString("_UI_SourceTargetCouple_refSourceToEdge_description"), //$NON-NLS-1$
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefSourceToEdge(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration sourceObjConf = couple.getSourceNode().getObject();
                ObjectConfiguration edgeObjConf = ((PartConfiguration) couple.eContainer()).getObject();
                if (sourceObjConf instanceof ModelObjectConfiguration && edgeObjConf instanceof ModelObjectConfiguration)
                {
                    //containments.addAll(getReachableObjectsOfType(((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass(), )
                    for (Iterator iter = ((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) edgeObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Ref Edge To Source feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefEdgeToSourcePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refEdgeToSource_feature"),
                getString("_UI_SourceTargetCouple_refEdgeToSource_description"),
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefEdgeToSource(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration sourceObjConf = couple.getSourceNode().getObject();
                ObjectConfiguration edgeObjConf = ((PartConfiguration) couple.eContainer()).getObject();
                if (sourceObjConf instanceof ModelObjectConfiguration && edgeObjConf instanceof ModelObjectConfiguration)
                {
                    for (Iterator iter = ((ModelObjectConfiguration) edgeObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Ref Target To Edge feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefTargetToEdgePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refTargetToEdge_feature"),
                getString("_UI_SourceTargetCouple_refTargetToEdge_description"),
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefTargetToEdge(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration targetObjConf = couple.getTargetNode().getObject();
                ObjectConfiguration edgeObjConf = ((PartConfiguration) couple.eContainer()).getObject();
                if (targetObjConf instanceof ModelObjectConfiguration && edgeObjConf instanceof ModelObjectConfiguration)
                {
                    for (Iterator iter = ((ModelObjectConfiguration) targetObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) edgeObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Ref Edge To Target feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefEdgeToTargetPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refEdgeToTarget_feature"),
                getString("_UI_SourceTargetCouple_refEdgeToTarget_description"),
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefEdgeToTarget(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration targetObjConf = couple.getTargetNode().getObject();
                ObjectConfiguration edgeObjConf = ((PartConfiguration) couple.eContainer()).getObject();
                if (targetObjConf instanceof ModelObjectConfiguration && edgeObjConf instanceof ModelObjectConfiguration)
                {
                    for (Iterator iter = ((ModelObjectConfiguration) edgeObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) targetObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Ref Source To Target feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefSourceToTargetPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refSourceToTarget_feature"), //$NON-NLS-1$
                getString("_UI_SourceTargetCouple_refSourceToTarget_description"), //$NON-NLS-1$
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefSourceToTarget(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration sourceObjConf = couple.getSourceNode().getObject();
                ObjectConfiguration targetObjConf = couple.getTargetNode().getObject();
                if (sourceObjConf instanceof ModelObjectConfiguration && targetObjConf instanceof ModelObjectConfiguration)
                {
                    for (Iterator iter = ((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) targetObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });        
    }

    /**
     * This adds a property descriptor for the Ref Target To Source feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addRefTargetToSourcePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SourceTargetCouple_refTargetToSource_feature"),
                getString("_UI_SourceTargetCouple_refTargetToSource_description"),
                ConfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefTargetToSource(),
                true, null, getString("_UI_ModelUpdatePropertyCategory"), null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
                SourceTargetCouple couple = (SourceTargetCouple) object;
                ObjectConfiguration sourceObjConf = couple.getSourceNode().getObject();
                ObjectConfiguration targetObjConf = couple.getTargetNode().getObject();
                if (sourceObjConf instanceof ModelObjectConfiguration && targetObjConf instanceof ModelObjectConfiguration)
                {
                    for (Iterator iter = ((ModelObjectConfiguration) targetObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                    {
                        EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                        if (eStructuralFeature.getEType() instanceof EClass)
                        {
                            if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass()))
                            {
                                containments.add(eStructuralFeature);
                            }
                        }
                    }
                }
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This returns SourceTargetCouple.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/SourceTargetCouple"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * Display SourceNode -> TargetNode as the Label
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getText(Object object)
    {
        String labelSrc = "";
        if (((SourceTargetCouple)object).getSourceNode() != null && ((SourceTargetCouple)object).getSourceNode().getObject() != null)
        {
            labelSrc = ((SourceTargetCouple)object).getSourceNode().getObject().getName();
        }
        String labelDst = "";
        if (((SourceTargetCouple)object).getTargetNode() != null && ((SourceTargetCouple)object).getTargetNode().getObject() != null)
        {
            labelDst = ((SourceTargetCouple)object).getTargetNode().getObject().getName();
        }
        return getString("_UI_SourceTargetCouple_type") + " " + labelSrc + " -> " + labelDst;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(SourceTargetCouple.class))
        {
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing all of the children that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator()
    {
        return ConfiguratorPlugin.INSTANCE;
    }

}
