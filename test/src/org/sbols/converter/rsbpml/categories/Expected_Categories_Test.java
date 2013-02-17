package org.sbols.converter.rsbpml.categories;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;

public class Expected_Categories_Test {
	@Test
    public void Expected_Categories_Test() throws JAXBException, IOException {
	 System.out.println("Expected_Categories_Test");
     //Get input for test
     Rsbpml rsbpmlData = ReadRSBPML.file("test/data/categories/Categories_Test.xml");

     //Do the test
     SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
     String actual = ReadFile.sbolDocToString(SbolDoc);
     
     // Sometimes we generate the expected results using the test - cheating
     WriteFile.toPath(SbolDoc, "test/data/rdfout/Categories_Out.sbol.xml");
     
     //Get expected result
     String expected = ReadFile.fromPath("test/data/categories/Categories_Expected.sbol.xml");

     //Compare
     assertTrue("Diffs found", ReadFile.compare(expected, actual));
 }
}
