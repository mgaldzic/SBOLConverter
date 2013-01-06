/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbolstandard.core.SequenceAnnotation;

/**
 *
 * @author mgaldzic
 */
public abstract class SubThing {

    protected abstract SequenceAnnotation getNewSA(Rsbpml rsbpmlData, int index);

    public SequenceAnnotation toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index, SequenceAnnotation nextSA) {
        SequenceAnnotation newAnnotation = getNewSA(rsbpmlData, index);

        if (nextSA != null) {
            newAnnotation.addPrecede(nextSA);
        }
        return newAnnotation;
    }
}
