package org.sbols.converter.rsbpml;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.sbols.converter.rsbpml.issues.*;

/**
 * 
 * @author mgaldzic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	ErrorPartNotFound_Test.class,
	TitleBBa_AndExtraText_Test.class,
	EndEQ0andLTStartFeature_Test.class,
	DCandFeatureSame_Test.class
    })
public class IssuesSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

}
