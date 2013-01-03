/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.sbols.converter.sbol.PartsRegistryDnaComponent;

/**
 * For Subpart and Scar to be related to each other
 * @author mgaldzic
 */

public abstract class SubThing {
    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick) {
        return biobrick;
    }
}
