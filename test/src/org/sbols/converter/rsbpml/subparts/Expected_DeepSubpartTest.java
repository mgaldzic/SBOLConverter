/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.subparts;

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
 *
 * @author mgaldzic
 */
public class Expected_DeepSubpartTest {

    @Test
    public void Expected_DeepSubpartTest() throws JAXBException, IOException {
        System.out.println("Expected_DeepSubpartTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/subparts/Valid_DeepSubpartTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        FileOutputStream out = new FileOutputStream("test/data/rdfout/Expected_DeepSubpartTest.sbol.xml");
        //TODO the output file here is incomplete
        SBOLFactory.write(Doc, out);
        fail("The test case is stub, no actual test.");
    }
}
