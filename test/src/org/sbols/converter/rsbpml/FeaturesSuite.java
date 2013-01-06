/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.features.Expected_FeaturesTest;
import org.sbols.converter.rsbpml.features.Valid_FeaturesTest;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Valid_FeaturesTest.class,
    Expected_FeaturesTest.class
})
public class FeaturesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
