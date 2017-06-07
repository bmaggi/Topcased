/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * Represents an element referenced by a model but which is part of another model which will be updated. Instances of
 * this class store a list of the current uses of the original object and a list of candidate replacements. This is used
 * to assist the user during the import procedure.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class FrontierElement
{
    public static class Usage
    {
        private final EObject source;

        private final String relation;

        private final EObject target;
        
        private EClassifier requiredType;

        public Usage(EObject source, String relation, EObject target)
        {
            this.source = source;
            this.target = target;
            this.relation = relation;
        }

        public EObject getSource()
        {
            return source;
        }

        public String getRelation()
        {
            return relation;
        }

        public EObject getTarget()
        {
            return target;
        }

		public EClassifier getRequiredType() {
			return requiredType;
		}

		public void setRequiredType(EClassifier requiredType) {
			this.requiredType = requiredType;
		}
    }

    private final EObject element;

    private final Collection<Usage> usages;

    private EObject replacement;
    
    private boolean isPerfectMatch;

    private List<EObject> candidates;

    public FrontierElement(EObject element, Collection<Usage> usages)
    {
        this.element = element;
        this.usages = usages;
        this.isPerfectMatch = false;
    }

    public EObject getElement()
    {
        return element;
    }

    public Collection<Usage> getUsages()
    {
        return usages;
    }

    public EObject getReplacement()
    {
        return replacement;
    }

    public boolean isPerfectMatch() {
		return isPerfectMatch;
	}

	public void setPerfectMatch(boolean isPerfectMatch) {
		this.isPerfectMatch = isPerfectMatch;
	}

	public void setReplacement(EObject replacement)
    {
        this.replacement = replacement;
    }

    public List<EObject> getCandidates()
    {
        return candidates;
    }

    public void setCandidates(List<EObject> candidates)
    {
        this.candidates = candidates;
    }

    public static Map<EObject, EObject> getReplacementMapping(Collection<FrontierElement> elements)
    {
        Map<EObject, EObject> result = new HashMap<EObject, EObject>();
        for (FrontierElement elt : elements)
        {
            result.put(elt.getElement(), elt.getReplacement());
        }
        return result;
    }
}
