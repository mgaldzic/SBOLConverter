/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.features.TitleBBa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.features.TitleBBa.AlreadyASubPart.*;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	Expected_TitleBBa_Feature_Test.class,
	Expected_NotASubPartFeature_Test.class,
	Expected_TrailingSpaceFeature_Test.class,
	Expected_AlreadyASubPart_Suite.class
})
public class Expected_TitleBBa_Feature_Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
