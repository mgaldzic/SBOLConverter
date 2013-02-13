package org.sbols.converter.rsbpml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.features.*;
import org.sbols.converter.rsbpml.features.EndStart.*;
import org.sbols.converter.rsbpml.features.TitleBBa.Expected_TitleBBa_Feature_Suite;


/**
 * 
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ Expected_TwoFeaturesTest.class,
		Expected_NotAPartWOTitleFeature_Test.class,
		Expected_NotAPartWTitleFeature_Test.class,
		Expected_TitlepSB_Feature_Test.class,
		
		Expected_EndStartSuite.class,
		Expected_TitleBBa_Feature_Suite.class})

public class ExpectedFeaturesSuite {
	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
}
