/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.generator;

import java.util.HashMap;
import java.util.Map;

import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * @author Nicolas
 * 
 * @param <T>
 */
public abstract class ObjectGenerator<T>
{

    private static final Map<Class< ? extends ObjectGenerator< ? >>, ObjectGenerator< ? >> generators = new HashMap<Class< ? extends ObjectGenerator< ? >>, ObjectGenerator< ? >>();

    /**
     * @param genClass 
     * @param <O> 
     * @return O
     * @throws GeneratorException 
     */
    @SuppressWarnings("unchecked")
    public final static <O extends ObjectGenerator< ? >> O getInstance(Class<O> genClass) throws GeneratorException
    {
        O instance = null;
        try
        {
            instance = (O) generators.get(genClass);
            if (instance == null)
            {
                instance = genClass.newInstance();
                generators.put(genClass, instance);
            }
        }
        catch (Exception e)
        {
            throw new GeneratorException("Impossible to found or instanciate the generator " + genClass.getName());
        }
        return instance;
    }

    /**
     * Return true whether something can be generated from the given PartConfiguration
     * 
     * @param partConfiguration the PartConfiguration
     * @return true whether the model element associated with the Part is not abstract
     */
    public boolean isGenerable(PartConfiguration partConfiguration)
    {
        ObjectConfiguration objectConf = partConfiguration.getObject();
        if (objectConf instanceof ModelObjectConfiguration)
        {
            ModelObjectConfiguration modelObjectConf = (ModelObjectConfiguration) objectConf;
            return !modelObjectConf.getGenClass().getEcoreClass().isAbstract();
        }
        return true;
    }
    
    /**
     * Create a GMF element of type <G> based on a Topcased element <T> 
     * @param topCasedObject 
     * @param gmfClass 
     * @param <G> 
     * @return <G>
     * @throws GeneratorException 
     */
    protected abstract <G> G createGMFObject(T topCasedObject, Class<G> gmfClass) throws GeneratorException;
}
