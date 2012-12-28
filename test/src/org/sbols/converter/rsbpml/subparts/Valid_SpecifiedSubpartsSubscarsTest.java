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
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class Valid_SpecifiedSubpartsSubscarsTest {

    @Test
    public void Valid_SpecifiedSubpartsSubscarsTest() throws JAXBException, FileNotFoundException {
        System.out.println("Valid_SpecifiedSubpartsSubscarsTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/subparts/Valid_SpecifiedSubpartsSubscarsTest.xml");
        SBOLDocument Doc = SBOLFactory.createDocument();
        Doc.addContent(rsbpmlData.toSbol());
        SBOLFactory.validate(Doc);
    }
}