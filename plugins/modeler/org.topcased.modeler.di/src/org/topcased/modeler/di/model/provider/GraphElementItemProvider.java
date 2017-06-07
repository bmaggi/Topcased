/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphElementItemProvider.java,v 1.18 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphElement;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.di.model.GraphElement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class GraphElementItemProvider extends DiagramElementItemProvider implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphElementItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addPositionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Position feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addPositionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_GraphElement_position_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_GraphElement_position_feature", "_UI_GraphElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.GRAPH_ELEMENT__POSITION, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Collection< ? extends EStructuralFeature> getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__ANCHORAGE);
            childrenFeatures.add(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL);
            childrenFeatures.add(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED);
            childrenFeatures.add(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__LINK);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child)
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns GraphElement.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/GraphElement")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        GraphElement graphElement = (GraphElement) object;
        return getString("_UI_GraphElement_type") + " " + graphElement.isVisible(); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(GraphElement.class))
        {
            case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__ANCHORAGE,
                DiagramInterchangeFactory.eINSTANCE.createGraphConnector()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
                DiagramInterchangeFactory.eINSTANCE.createSemanticModelBridge()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
                DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
                DiagramInterchangeFactory.eINSTANCE.createSimpleSemanticModelElement()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createGraphEdge()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createGraphNode()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createDiagram()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createLeafElement()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createTextElement()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createImage()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createGraphicPrimitive()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createReference()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createPolyline()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createEllipse()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createEdgeObjectOffset()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED,
                DiagramInterchangeFactory.eINSTANCE.createEdgeObjectUV()));

        newChildDescriptors.add(createChildParameter(DiagramInterchangePackage.Literals.GRAPH_ELEMENT__LINK,
                DiagramInterchangeFactory.eINSTANCE.createDiagramLink()));
    }

}
