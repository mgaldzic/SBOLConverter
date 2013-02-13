/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.features.EndStart;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import static org.junit.Assert.fail;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;
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
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/features/endstart/endLTstartFeature_Test.xml");
        //Do the test: convert validates and raises an exception in this case
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        fail("The test should check if the just the bad feature is thrown away not the whole thing. See BBa_G0002");
    }
}
