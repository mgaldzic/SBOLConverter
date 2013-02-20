package org.sbols.converter.rsbpml.issues;

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
import org.sbolstandard.core.SBOLValidationException;

	/**
	 * Tests the converter successfully converts the simplest dna component,
	 * containing just a name.
	 * 
	 * @author mgaldzic
	 */
	public class RepeatedSubPartSubComponents {

		@Ignore
		@Test
		public void RepeatedSubPartSubComponents() throws JAXBException, IOException, SBOLValidationException {
			System.out.println("RepeatedSubPartSubComponents");
			// Get input for test
			Rsbpml rsbpmlData = ReadRSBPML.file("test/data/issues/RepeatedSubPartSubComponents.xml");

			// Do the test
			SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
			String actual = ReadFile.sbolDocToString(SbolDoc);

			// Sometimes we generate the expected results using the test - cheating
			WriteFile.toPath(SbolDoc,"test/data/rdfout/issues/RepeatedSubPartSubComponents_Out.sbol.xml");

			// Get expected result
			String expected = ReadFile.fromPath("test/data/issues/RepeatedSubPartSubComponents_Expected.sbol.xml");

			// Compare
			assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
		}
	}
