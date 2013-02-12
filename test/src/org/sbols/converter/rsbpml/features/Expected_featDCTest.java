/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.features;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
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

public class Expected_featDCTest {
    
    @Test
    public void Expected_NotAPartWOTitleFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_NotAPartWOTitleFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/NotAPartWOTitleFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/NotAPartWOTitleFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/NotAPartWOTitleFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
    
    
    @Test
    public void Expected_NotAPartWTitleFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_NotAPartWTitleFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/NotAPartWTitleFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/NotAPartWTitleFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/NotAPartWTitleFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
    
    @Ignore
    @Test
    public void Expected_TitleBBa_AlreadyADeepSubPartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_AlreadyADeepSubPartFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_AlreadyADeepSubPartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/TitleBBa_AlreadyADeepSubPartFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_AlreadyADeepSubPartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
     
    @Ignore
    @Test
    public void Expected_TitleBBa_AlreadyASpecifiedSubpartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_AlreadyASpecifiedSubpartFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_AlreadyASpecifiedSubpartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/TitleBBa_AlreadyASpecifiedSubpartFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_AlreadyASpecifiedSubpartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
     
    @Ignore
    @Test
    public void Expected_TitleBBa_AlreadyASpecifiedSubscarSubPartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_AlreadyASpecifiedSubscarSubPartFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_AlreadyASpecifiedSubscarSubPartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/TitleBBa_AlreadyASpecifiedSubscarSubPartFeature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_AlreadyASpecifiedSubscarSubPartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
     

    @Test
    public void Expected_TitleBBa_Feature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_Feature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_Feature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/TitleBBa_Feature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_Feature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
     

    @Test
    public void Expected_TitleBBa_NotASubPartFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_NotASubPartFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_NotASubPartFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_NotASubPartFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
     
    @Test
    public void Expected_TitleBBa_TrailingSpaceFeature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitleBBa_TrailingSpaceFeature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitleBBa_TrailingSpaceFeature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitleBBa_TrailingSpaceFeature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }

    @Test
    public void Expected_TitlepSB_Feature_Test() throws JAXBException, IOException {
        System.out.println("Expected_TitlepSB_Feature_Test");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/TitlepSB_Feature_Test.xml");
        //Do the test
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        String actual = ReadFile.sbolDocToString(SbolDoc);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/TitlepSB_Feature_Out.sbol.xml");
        //Get expected result
        String expected = ReadFile.fromPath("test/data/features/TitlepSB_Feature_Expected.sbol.xml");
        //Compare
        assertTrue("Diffs found: ", ReadFile.compare(expected, actual));
    }
}
