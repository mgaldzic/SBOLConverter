/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 * Tests the converter successfully converts the simplest dna component,
 * containing just a name.
 *
 * @author mgaldzic
 */
public class Expected_Basic_PartTest {

    @Test
    public void Expected_BasicPartTest() throws JAXBException, IOException {
        System.out.println("Expected_BasicPartTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_BasicPartTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);

        FileOutputStream out = new FileOutputStream("test/data/rdfout/Expected_Basic_PartTest.sbol.xml");
        SBOLFactory.write(Doc, out);
        fail("The test case is stub, no actual test.");
    }
}
