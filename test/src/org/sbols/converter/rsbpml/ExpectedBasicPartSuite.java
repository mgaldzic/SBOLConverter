package org.sbols.converter.rsbpml;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
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
	Expected_Basic_PartTest.class, 
    Expected_IdTest.class,
    Expected_MixedCaseNonSOTypeTest.class,
    Expected_MixedCaseSOTypeTest.class,
    Expected_MultiSOTypesTest.class,
    Expected_NicknameTest.class,
    Expected_NonSOTypesTest.class,
    Expected_SequenceTest.class,
    Expected_SOTypeTest.class, 
    Expected_SplitLineSequence_Test.class
    })
public class ExpectedBasicPartSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
