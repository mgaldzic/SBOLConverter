/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbols.converter.rsbpml.subparts;

/**
 *
 * @author mgaldzic
 */

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_FeaturesTest {

    @Test
    public void Valid_FeaturesTest() throws JAXBException, IOException {
        System.out.println("Valid_FeaturesTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/Valid_FeaturesTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}
