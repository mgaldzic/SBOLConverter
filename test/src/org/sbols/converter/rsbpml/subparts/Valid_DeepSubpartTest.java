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
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_DeepSubpartTest {

    @Test
    public void Valid_DeepSubpartTest() throws JAXBException, IOException {
        System.out.println("Valid_DeepSubpartTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/DeepSubpart_Test.xml");

        SBOLDocument Doc = SBOLConverter.convert(rsbpmlData);

        SBOLFactory.validate(Doc);
    }
}
