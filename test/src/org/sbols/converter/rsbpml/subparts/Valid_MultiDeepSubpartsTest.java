/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Valid_MultiDeepSubpartsTest {

    /**
     * Test of toSbol method, of class deep_subparts.
     */
    @Test
    public void Valid_MultiDeepSubpartsTest() throws JAXBException, FileNotFoundException {
        System.out.println("Valid_MultiDeepSubpartsTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/MultiDeepSubparts_Test.xml");
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        SBOLFactory.validate(SbolDoc);
    }
}
