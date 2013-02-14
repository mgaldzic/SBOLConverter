package org.sbols.converter.rsbpml.features.TitleBBa.AlreadyASubPart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	Expected_DeepSubPartFeature_Test.class,
	Expected_SpecifiedSubpartFeature_Test.class,
	Expected_SpecifiedSubscarSubPartFeature_Test.class,
	Expected_SubPartFeature_Test.class,
	Expected_SubPartWNewTypesFeature_Test.class
})
public class Expected_AlreadyASubPart_Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
