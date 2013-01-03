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
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.DiffMatchPatch;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Expected_SpecifiedSubscarsTest {

    @Test
    public void Expected_SpecifiedSubscarsTest() throws JAXBException, FileNotFoundException, IOException {
        System.out.println("Expected_SpecifiedSubscarsTest");

        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/Valid_SpecifiedSubscarsTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);

        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/Out_SpecifiedSubscarsTest.sbol.xml");
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/subparts/Valid_SpecifiedSubscarsTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
