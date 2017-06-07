/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeItemProviderAdapterFactory.java,v 1.16 2008/12/05 13:53:54 jako Exp $
 */
package org.topcased.modeler.di.model.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.topcased.modeler.di.model.util.DiagramInterchangeAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramInterchangeItemProviderAdapterFactory extends DiagramInterchangeAdapterFactory implements
        ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeItemProviderAdapterFactory()
    {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Property} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PropertyItemProvider propertyItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Property}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPropertyAdapter()
    {
        if (propertyItemProvider == null)
        {
            propertyItemProvider = new PropertyItemProvider(this);
        }

        return propertyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.GraphEdge} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected GraphEdgeItemProvider graphEdgeItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.GraphEdge}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGraphEdgeAdapter()
    {
        if (graphEdgeItemProvider == null)
        {
            graphEdgeItemProvider = new GraphEdgeItemProvider(this);
        }

        return graphEdgeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.GraphNode} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected GraphNodeItemProvider graphNodeItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.GraphNode}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGraphNodeAdapter()
    {
        if (graphNodeItemProvider == null)
        {
            graphNodeItemProvider = new GraphNodeItemProvider(this);
        }

        return graphNodeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.GraphConnector} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected GraphConnectorItemProvider graphConnectorItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.GraphConnector}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGraphConnectorAdapter()
    {
        if (graphConnectorItemProvider == null)
        {
            graphConnectorItemProvider = new GraphConnectorItemProvider(this);
        }

        return graphConnectorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Diagram} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DiagramItemProvider diagramItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Diagram}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDiagramAdapter()
    {
        if (diagramItemProvider == null)
        {
            diagramItemProvider = new DiagramItemProvider(this);
        }

        return diagramItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.SemanticModelBridge} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SemanticModelBridgeItemProvider semanticModelBridgeItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.SemanticModelBridge}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSemanticModelBridgeAdapter()
    {
        if (semanticModelBridgeItemProvider == null)
        {
            semanticModelBridgeItemProvider = new SemanticModelBridgeItemProvider(this);
        }

        return semanticModelBridgeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.EMFSemanticModelBridge} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EMFSemanticModelBridgeItemProvider emfSemanticModelBridgeItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.EMFSemanticModelBridge}.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEMFSemanticModelBridgeAdapter()
    {
        if (emfSemanticModelBridgeItemProvider == null)
        {
            emfSemanticModelBridgeItemProvider = new EMFSemanticModelBridgeItemProvider(this);
        }

        return emfSemanticModelBridgeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.SimpleSemanticModelElement} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SimpleSemanticModelElementItemProvider simpleSemanticModelElementItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.SimpleSemanticModelElement}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createSimpleSemanticModelElementAdapter()
    {
        if (simpleSemanticModelElementItemProvider == null)
        {
            simpleSemanticModelElementItemProvider = new SimpleSemanticModelElementItemProvider(this);
        }

        return simpleSemanticModelElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.DiagramLink} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramLinkItemProvider diagramLinkItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.DiagramLink}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDiagramLinkAdapter()
    {
        if (diagramLinkItemProvider == null)
        {
            diagramLinkItemProvider = new DiagramLinkItemProvider(this);
        }

        return diagramLinkItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.LeafElement} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected LeafElementItemProvider leafElementItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.LeafElement}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createLeafElementAdapter()
    {
        if (leafElementItemProvider == null)
        {
            leafElementItemProvider = new LeafElementItemProvider(this);
        }

        return leafElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.TextElement} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected TextElementItemProvider textElementItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.TextElement}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTextElementAdapter()
    {
        if (textElementItemProvider == null)
        {
            textElementItemProvider = new TextElementItemProvider(this);
        }

        return textElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Image} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ImageItemProvider imageItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Image}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createImageAdapter()
    {
        if (imageItemProvider == null)
        {
            imageItemProvider = new ImageItemProvider(this);
        }

        return imageItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.GraphicPrimitive} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected GraphicPrimitiveItemProvider graphicPrimitiveItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.GraphicPrimitive}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGraphicPrimitiveAdapter()
    {
        if (graphicPrimitiveItemProvider == null)
        {
            graphicPrimitiveItemProvider = new GraphicPrimitiveItemProvider(this);
        }

        return graphicPrimitiveItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Reference} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ReferenceItemProvider referenceItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Reference}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createReferenceAdapter()
    {
        if (referenceItemProvider == null)
        {
            referenceItemProvider = new ReferenceItemProvider(this);
        }

        return referenceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Polyline} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PolylineItemProvider polylineItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Polyline}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPolylineAdapter()
    {
        if (polylineItemProvider == null)
        {
            polylineItemProvider = new PolylineItemProvider(this);
        }

        return polylineItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.Ellipse} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EllipseItemProvider ellipseItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.Ellipse}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEllipseAdapter()
    {
        if (ellipseItemProvider == null)
        {
            ellipseItemProvider = new EllipseItemProvider(this);
        }

        return ellipseItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.EdgeObjectOffset} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EdgeObjectOffsetItemProvider edgeObjectOffsetItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.EdgeObjectOffset}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEdgeObjectOffsetAdapter()
    {
        if (edgeObjectOffsetItemProvider == null)
        {
            edgeObjectOffsetItemProvider = new EdgeObjectOffsetItemProvider(this);
        }

        return edgeObjectOffsetItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.modeler.di.model.EdgeObjectUV} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EdgeObjectUVItemProvider edgeObjectUVItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.modeler.di.model.EdgeObjectUV}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEdgeObjectUVAdapter()
    {
        if (edgeObjectUVItemProvider == null)
        {
            edgeObjectUVItemProvider = new EdgeObjectUVItemProvider(this);
        }

        return edgeObjectUVItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory()
    {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
    {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type)
    {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type)
    {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type)
    {
        if (isFactoryForType(type))
        {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class) || (((Class< ? >) type).isInstance(adapter)))
            {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification)
    {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null)
        {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void dispose()
    {
        if (propertyItemProvider != null)
            propertyItemProvider.dispose();
        if (graphEdgeItemProvider != null)
            graphEdgeItemProvider.dispose();
        if (graphNodeItemProvider != null)
            graphNodeItemProvider.dispose();
        if (graphConnectorItemProvider != null)
            graphConnectorItemProvider.dispose();
        if (diagramItemProvider != null)
            diagramItemProvider.dispose();
        if (semanticModelBridgeItemProvider != null)
            semanticModelBridgeItemProvider.dispose();
        if (emfSemanticModelBridgeItemProvider != null)
            emfSemanticModelBridgeItemProvider.dispose();
        if (simpleSemanticModelElementItemProvider != null)
            simpleSemanticModelElementItemProvider.dispose();
        if (diagramLinkItemProvider != null)
            diagramLinkItemProvider.dispose();
        if (leafElementItemProvider != null)
            leafElementItemProvider.dispose();
        if (textElementItemProvider != null)
            textElementItemProvider.dispose();
        if (imageItemProvider != null)
            imageItemProvider.dispose();
        if (graphicPrimitiveItemProvider != null)
            graphicPrimitiveItemProvider.dispose();
        if (referenceItemProvider != null)
            referenceItemProvider.dispose();
        if (polylineItemProvider != null)
            polylineItemProvider.dispose();
        if (ellipseItemProvider != null)
            ellipseItemProvider.dispose();
        if (edgeObjectOffsetItemProvider != null)
            edgeObjectOffsetItemProvider.dispose();
        if (edgeObjectUVItemProvider != null)
            edgeObjectUVItemProvider.dispose();
    }

}
