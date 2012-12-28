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
 *
 * @author mgaldzic
 */
public class Expected_NicknameTest {
    @Test
    public void Expected_NicknameTest() throws JAXBException, IOException {
        System.out.println("Expected_NicknameTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_NicknameTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/basic/Valid_NicknameTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
