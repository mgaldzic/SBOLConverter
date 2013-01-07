/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.features;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadFile;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;

/**
 *
 * @author mgaldzic
 */
public class Invalid_endLTstartFeatureTest {

    @Test(expected = SBOLValidationException.class)
    public void Invalid_endLTstartFeatureTest() throws JAXBException, IOException {
        System.out.println("Invalid_endLTstartFeatureTest");
        //Get input for test
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/endLTstartFeature_Test.xml");
        //Do the test: convert validates and raises an exception in this case
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
    }
}