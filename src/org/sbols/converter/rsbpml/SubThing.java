/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.sbolstandard.core.DnaComponent;

/**
 * For Subpart and Scar to be related to each other
 * @author mgaldzic
 */

public abstract class SubThing {
    public DnaComponent toSbol(DnaComponent biobrick) {
        return biobrick;
    }
}
