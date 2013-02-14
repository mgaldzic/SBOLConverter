package org.sbols.converter.rsbpml.features.EndStart;

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
		Expected_PostionsFeaturesTest.class,
		Invalid_startLToneFeatureTest.class,
		Invalid_endLTstartFeatureTest.class})

public class Expected_EndStartSuite {
	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
}
