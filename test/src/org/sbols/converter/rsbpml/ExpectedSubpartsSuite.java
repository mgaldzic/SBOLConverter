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
    Expected_DeepSubpartTest.class,
    Expected_FeaturesTest.class,
    Expected_MultiDeepSubpartsTest.class,
    Expected_SpecifiedSubpartsSubscarsTest.class, 
    Expected_SpecifiedSubpartsTest.class,
    Expected_SpecifiedSubscarsTest.class
})
public class ExpectedSubpartsSuite {

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
