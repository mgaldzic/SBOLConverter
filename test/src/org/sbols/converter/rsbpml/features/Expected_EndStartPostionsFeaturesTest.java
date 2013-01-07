/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.features;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLValidationException;

/**
 *
 * @author mgaldzic
 */
public class Expected_EndStartPostionsFeaturesTest {

    @Test
    public void Expected_endEQstartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_endEQstartFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/endEQstartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/endEQstartFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/endEQstartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }

    @Test
    public void Expected_endGTstartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_endGTstartFeatureTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/endGTstartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/endGTstartFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/endGTstartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }

    @Test
    public void Expected_startEQoneFeatureTest() throws JAXBException, IOException {
        System.out.println("Expected_startEQoneFeatureTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/startEQoneFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/startEQoneFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/startEQoneFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }

    @Test
    public void Expected_startGToneFeatureTest() throws JAXBException, IOException {
        System.out.println("Expected_startGToneFeatureTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/startGToneFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/startGToneFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/startGToneFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }

    @Test
    public void Expected_startLToneFeatureTest() throws JAXBException, IOException {
        System.out.println("Expected_startLToneFeatureTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/startLToneFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/startLToneFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/startLToneFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
