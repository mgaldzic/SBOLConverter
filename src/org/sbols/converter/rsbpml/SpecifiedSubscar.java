/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbolstandard.core.SequenceAnnotation;

/**
 * For SubpartSubscar and Scar to be related to each other
 *
 * @author mgaldzic
 */
public abstract class SpecifiedSubscar {

    protected SequenceAnnotation getNewSA(Rsbpml rsbpmlData, int index) {
        //gets override in subclass
        SequenceAnnotation newAnnotation = null;
        return newAnnotation;
    }
    
    public SequenceAnnotation toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index, SequenceAnnotation nextSA) {
        SequenceAnnotation newAnnotation = getNewSA(rsbpmlData, index);
        
        if (nextSA != null) {
            newAnnotation.addPrecede(nextSA);
        }      
        return newAnnotation;
    }
}
