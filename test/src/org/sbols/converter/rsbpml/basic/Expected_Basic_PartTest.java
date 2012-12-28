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
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.SBOLDocument;

/**
 * Tests the converter successfully converts the simplest dna component,
 * containing just a name.
 *
 * @author mgaldzic
 */
public class Expected_Basic_PartTest {

    @Test
    public void Expected_BasicPartTest() throws JAXBException, IOException {
        System.out.println("Expected_BasicPartTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_BasicPartTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/basic/Valid_BasicPartTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
