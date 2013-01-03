/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbols.converter.util.WriteFile;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Valid_IdTest {
    @Test
    public void Valid_IdTest() throws JAXBException, IOException {
        System.out.println("Valid_IdTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_IdTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}
