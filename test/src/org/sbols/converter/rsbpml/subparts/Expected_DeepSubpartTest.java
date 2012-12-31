/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadXML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Expected_DeepSubpartTest {

    @Test
    public void Expected_DeepSubpartTest() throws JAXBException, IOException {
        System.out.println("Expected_DeepSubpartTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadXML.file("test/data/subparts/Valid_DeepSubpartTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/Out_DeepSubpartTest.sbol.xml");
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/subparts/Valid_DeepSubpartTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
