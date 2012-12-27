/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;
import org.sbols.converter.rsbpml.specified_subscars;
import org.sbols.converter.rsbpml.subpart;
import org.sbolstandard.core.DnaComponent;

/**
 *
 * @author mgaldzic
 */
public class Valid_SpecifiedSubcarsTest {
    
    @Ignore
    @Test
    public void Valid_SpecifiedSubcarsTest() {
        System.out.println("Valid_SpecifiedSubcarsTest");
        specified_subscars instance = new specified_subscars();
        subpart expResult = null;
        subpart result = instance.getSubpart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubpart method, of class specified_subscars.
     */
    @Ignore
    @Test
    public void testSetSubpart() {
        System.out.println("setSubpart");
        subpart subpart = null;
        specified_subscars instance = new specified_subscars();
        instance.setSubpart(subpart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSbol method, of class specified_subscars.
     */
    @Ignore
    @Test
    public void testToSbol() {
        System.out.println("toSbol");
        DnaComponent biobrick = null;
        specified_subscars instance = new specified_subscars();
        DnaComponent expResult = null;
        DnaComponent result = instance.toSbol(biobrick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
