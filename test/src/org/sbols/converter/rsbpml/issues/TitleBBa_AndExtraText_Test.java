package org.sbols.converter.rsbpml.issues;

import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.RsbpmlException;

/**
 * 
 * @author mgaldzic
 */
public class TitleBBa_AndExtraText_Test {

	@Test
	public void TitleBBa_AndExtraText_Test() throws Exception {
		System.out.println("TitleBBa_AndExtraText_Test");
		String infile = "test/data/issues/TitleBBa_AndExtraText.xml";
		String outfile = "test/data/rdfout/issues/TitleBBa_AndExtraText.sbol.xml";
		SBOLConverter.run_convert(infile, outfile);
	}
}
