package org.sbols.converter.util;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Ignore;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.rsbpml.RsbpmlException;
import org.sbolstandard.core.SBOLDocument;

import com.atlassian.xmlcleaner.XmlCleaner;

/**
 * 
 * @author mgaldzic
 */
public class stripNonValidXMLCharactersTest {

	@Ignore
	@Test
	public void stripNonValidXMLCharactersTest() throws Exception {
		System.out.println("stripNonValidXMLCharactersTest");
		String infile = "test/data/util/stripNonValidXMLCharactersTest.xml";
		String cleanedfile = "test/data/util/stripNonValidXMLCharactersTest_cleaned.xml";
		String outfile = "test/data/rdfout/stripNonValidXMLCharactersTest.sbol.xml";
		//String expectedfile = "test/data/util/stripNonValidXMLCharactersTest.sbol.xml";
		//SBOLConverter.run_convert(infile, outfile);
		
		
		//
		File f = new File(infile);
		XmlCleaner tester = new XmlCleaner(f);
		tester.clean();
		String out = f.getPath();
		String in = ReadFile.fromPath(f.getPath());
		String clean = ReadRSBPML.stripNonValidXMLCharacters(in);
		clean = ReadRSBPML.removeInvalidXMLCharacters(clean);
		System.out.println(clean);
		
		FileWriter fstream = new FileWriter(cleanedfile);
	    BufferedWriter o = new BufferedWriter(fstream);
		o.write(out.toString());
		o.close();
		
		
		JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream is = new ByteArrayInputStream(clean.getBytes());
        Rsbpml rsbpmlData = (Rsbpml) unmarshaller.unmarshal(is);
        
       // Rsbpml rsbpmlData = (Rsbpml) unmarshaller.unmarshal(new FileInputStream(path));
		// test input
	   //Rsbpml rsbpmlData = ReadRSBPML.file(infile);

		// Do the test
		
		SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
		//String actual = ReadFile.sbolDocToString(SbolDoc);

		// Sometimes we generate the expected results using the test - cheating
		WriteFile.toPath(SbolDoc, outfile);

		// Get expected result
		//String expected = ReadFile.fromPath(expectedfile);

		// Compare
		//assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
		//SBOLConverter.run_convert(infile, outfile);
		 
		 
	}
}
