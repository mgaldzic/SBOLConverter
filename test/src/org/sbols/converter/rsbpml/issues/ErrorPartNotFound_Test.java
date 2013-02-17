package org.sbols.converter.rsbpml.issues;

import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.RsbpmlException;


/**
 * 
 * @author mgaldzic
 */
public class ErrorPartNotFound_Test {

	@Test(expected = RsbpmlException.class)
	public void ErrorPartNotFound_Test() throws Exception {
		System.out.println("ErrorPartNotFound_Test");
		String infile = "test/data/issues/BBa_NotFound.xml"; 
		String outfile = "test/data/rdfout/issues/BBa_NotFound.sbol.xml";
		SBOLConverter.run_convert(infile,outfile);
	}
}
