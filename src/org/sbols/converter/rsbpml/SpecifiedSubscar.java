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
 * For SubpartSubscar and Scar to be related to each other
 *
 * @author mgaldzic
 */
public abstract class SpecifiedSubscar {

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index) {
        return biobrick;
    }

    protected SequenceAnnotation getNextSA(Rsbpml rsbpmlData, int index) {
        System.out.println("BEGIN" + index);
        SequenceAnnotation pSA = null;
        //Get next SA for SA.precedes, if it exists
        List<SpecifiedSubscar> mySpecifiedSubscars = rsbpmlData.getPart_list().getPart().getSpecified_subscars();
        System.out.println("my size :" + mySpecifiedSubscars.size() + " in+1 :" + (index + 1));
        System.out.println("my next :" + mySpecifiedSubscars.listIterator().next());
       
        if (mySpecifiedSubscars.size() > (index + 1) && mySpecifiedSubscars.listIterator().next() != null) {
            //Capture next SA
            pSA = mySpecifiedSubscars.listIterator().next() //For the next subpart
                    .toSbol(PartsRegistrySBOLFactory.createDnaComponent(), rsbpmlData, index + 1) //get that ones, index+1's, SBOL
                    .getAnnotations().get(index); //get the SA out of it
            //Make the .precedes connection
            System.out.println("pSA " + pSA.getURI());
        }
        System.out.println("END" + index);
        return pSA;
    }
}
