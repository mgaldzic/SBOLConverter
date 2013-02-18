package org.sbols.converter.rsbpml.issues;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;

/**
 * 
 * @author mgaldzic
 */
public class EndEQ0andLTStartFeature_Test {

	@Test
	public void EndEQ0andLTStartFeature_Test() throws JAXBException, IOException {
		System.out.println("EndEQ0andLTStartFeature_Test");
		// Get input for test
		Rsbpml rsbpmlData = ReadRSBPML.file("test/data/issues/EndEQ0andLTStartFeature.xml");
		// Do the test
		SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
		String actual = ReadFile.sbolDocToString(SbolDoc);
		// Sometimes we generate the expected results using the test - cheating
		WriteFile.toPath(SbolDoc, "test/data/rdfout/issues/EndEQ0andLTStartFeature_Out.sbol.xml");
		// Get expected result
		String expected = ReadFile.fromPath("test/data/issues/EndEQ0andLTStartFeature_Expected.sbol.xml");
		// Compare
		assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
	}

}