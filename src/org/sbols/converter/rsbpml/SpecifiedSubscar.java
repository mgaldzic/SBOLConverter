/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.sbols.converter.sbol.PartsRegistryDnaComponent;

/**
 *
 * @author mgaldzic
 */
public class SpecifiedSubscar extends Subpart{
    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index) {
        return biobrick;
    }
    
}
