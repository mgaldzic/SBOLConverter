/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadRSBPML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.SBOLDocument;

/**
 *
 * @author mgaldzic
 */
public class Valid_IdTest {
    @Test
    public void Valid_IdTest() throws JAXBException, IOException {
        System.out.println("Valid_IdTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/basic/Id_Test.xml");

        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        // Sometimes we generate the expected results using the test - cheating
        WriteFile.toPath(SbolDoc, "test/data/rdfout/Id_Out.sbol.xml");
        
        PartsRegistrySBOLFactory.validate(SbolDoc);
    }
}
