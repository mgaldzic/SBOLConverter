package org.sbols.org.converter.rsbpml;

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

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Test4_BasicPartwithBasicSubpart.class, Test3_BasicPartWithSequenceData.class, Test2_BasicPartWithNickname.class, Test5_BasicPartwithSOType.class, Test6_BasicPartwithSOTypes.class, Test1_BasicValidPart.class})
public class TestBasicParts {

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
