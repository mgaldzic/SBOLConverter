/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

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
public class Expected_MultiDeepSubpartsTest {

    @Test
    public void Expected_MultiDeepSubpartsTest() throws JAXBException, IOException {
        System.out.println("Expected_MultiDeepSubpartsTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/Valid_MultiDeepSubpartsTest.xml");

        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/Out_MultiDeepSubpartsTest.sbol.xml");
        
        //Get expected result
        String expected = ReadFile.fromPath("test/data/subparts/Valid_MultiDeepSubpartsTest.sbol.xml");

        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
