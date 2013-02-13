/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.features.*;
import org.sbols.converter.rsbpml.features.EndStart.Expected_EndStartPostionsFeaturesTest;
import org.sbols.converter.rsbpml.features.EndStart.Invalid_endLTstartFeatureTest;
import org.sbols.converter.rsbpml.features.EndStart.Invalid_startLToneFeatureTest;

/**
 *
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Expected_TwoFeaturesTest.class,
    Expected_EndStartPostionsFeaturesTest.class,
    Expected_featDCTest.class,
    Invalid_startLToneFeatureTest.class,
    Invalid_endLTstartFeatureTest.class
})
public class FeaturesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
