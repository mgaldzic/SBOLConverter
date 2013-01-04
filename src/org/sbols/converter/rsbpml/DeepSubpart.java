/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import java.util.List;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbolstandard.core.SequenceAnnotation;

/**
 *
 * @author mgaldzic
 */
public class DeepSubpart extends Subpart{
    
    @Override
    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index) {
        SequenceAnnotation newAnnotation = this.getNewSA(rsbpmlData, index);
        System.out.println("BEGIN"+index);
        System.out.println("SA "+ newAnnotation.getURI());
        //Get next SA for SA.precedes, if it exists
        List<DeepSubpart> myDeepSuparts= rsbpmlData.getPart_list().getPart().getDeep_subparts();
        if (myDeepSuparts.size() > (index+1) && myDeepSuparts.get(index+1) != null){
            //Capture next SA
            SequenceAnnotation pSA 
                    //For the next subpart
                    = myDeepSuparts.get(index+1)
                    //get that ones, index+1's, SBOL
                    .toSbol(PartsRegistrySBOLFactory.createDnaComponent(), rsbpmlData, index+1)
                    //get the SA out of it
                    .getAnnotations().get(index);
            //Make the .precedes connection
            System.out.println("pSA "+ pSA.getURI());
            newAnnotation.addPrecede(pSA);
        }
        System.out.println("END"+index);
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
    
}
