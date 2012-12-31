/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

import java.io.*;
import java.util.LinkedList;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbols.converter.util.DiffMatchPatch;
import org.sbols.converter.util.ReadFile;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Expected_SpecifiedSubscarsTest {

    @Test
    public void Valid_SpecifiedSubcarsTest() throws JAXBException, FileNotFoundException, IOException {
        System.out.println("Expected_SpecifiedSubcarsTest");

        //Get input for test
        Rsbpml rsbpmlData = ReadXML.file("test/data/subparts/Valid_SpecifiedSubcarsTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);

        // Sometimes we generate the expected results using the test - cheating
        //String file_out_path = "test/data/rdfout/Expected_SpecifiedSubcarsTest.sbol.xml";
        //     FileOutputStream fout = new FileOutputStream(file_out_path+"1");
        //     FileOutputStream fout = new FileOutputStream(file_out_path);
        //     SBOLFactory.write(SbolDoc, fout);
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/subparts/Valid_SpecifiedSubcarsTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
