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
import org.sbols.converter.rsbpml.basic.*;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Valid_BasicPartTest.class, 
    Valid_NicknameTest.class, 
    Valid_SequenceTest.class, 
    Valid_SOTypeTest.class, 
    Valid_MultiSOTypesTest.class,
    Valid_NonSOTypesTest.class, 
})
public class ValidBasicPartSuite {

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
