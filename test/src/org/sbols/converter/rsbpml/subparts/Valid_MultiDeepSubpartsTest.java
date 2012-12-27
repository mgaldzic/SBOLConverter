/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
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
        Rsbpml rsbpmlData = ReadXML.file("test/data/Valid_MultiDeepSubpartsTest.xml");
        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}
