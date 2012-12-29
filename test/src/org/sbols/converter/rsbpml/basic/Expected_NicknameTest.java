/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

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
        
        // Sometimes we generate the expected results using the test - cheating
        String file_out_path = "test/data/rdfout/Out_NicknameTest.sbol.xml";
        //     FileOutputStream fout = new FileOutputStream(file_out_path+"1");
             FileOutputStream fout = new FileOutputStream(file_out_path);
             SBOLFactory.write(SbolDoc, fout);
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/basic/Valid_NicknameTest.sbol.xml");

        //Compare
        assertTrue("Diffs found", ReadFile.compare(expected, actual));
    }
}
