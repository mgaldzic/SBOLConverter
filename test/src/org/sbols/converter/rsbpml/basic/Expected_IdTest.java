/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

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
public class Expected_IdTest {

    @Test
    public void Expected_IdTest() throws JAXBException, IOException {
        System.out.println("Expected_IdTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/basic/Valid_IdTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/Out_IdTest.sbol.xml");
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/basic/Valid_IdTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
