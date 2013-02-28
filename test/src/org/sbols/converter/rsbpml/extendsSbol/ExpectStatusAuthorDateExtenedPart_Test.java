package org.sbols.converter.rsbpml.extendsSbol;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;

/**
 * Tests the converter successfully converts the simplest dna component,
 * containing just a name.
 * 
 * @author mgaldzic
 */
public class ExpectStatusAuthorDateExtenedPart_Test {

	@Test
	public void ExpectStatusAuthorDateExtenedPart_Test() throws Exception {
		System.out.println("ExpectStatusAuthorDateExtenedPart_Test");

		String infile = "test/data/extendsSbol/StatusAuthorDateExtenedPart.xml";
		String outfile = "test/data/rdfout/extendsSbol/StatusAuthorDateExtenedPart.sbol.xml";
		String expectedfile = "test/data/extendsSbol/StatusAuthorDateExtenedPart_Expected.sbol.xml";
		SBOLConverter.run_convert(infile, outfile);
		
		 // Get input for test 
		Rsbpml rsbpmlData = ReadRSBPML.file(infile);
		 
		// Do the test 
		SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData); 
		String actual =	ReadFile.sbolDocToString(SbolDoc);
		 
		// Sometimes we generate the expected results using the test - cheating 
		WriteFile.toPath(SbolDoc, outfile);
		  
		 // Get expected result 
		String expected = ReadFile.fromPath(expectedfile);
		  
		 // Compare 
		 assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
	}
}
