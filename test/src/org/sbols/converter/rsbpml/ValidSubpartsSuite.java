package org.sbols.converter.rsbpml;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.subparts.*;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Valid_DeepSubpartTest.class,
    Valid_MultiDeepSubpartsTest.class,
    Valid_SpecifiedSubpartsSubscarsTest.class, 
    Valid_SpecifiedSubpartsTest.class,
    Valid_SpecifiedSubscarsTest.class
})
public class ValidSubpartsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
