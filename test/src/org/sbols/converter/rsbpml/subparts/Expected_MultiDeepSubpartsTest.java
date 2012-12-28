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
public class Expected_MultiDeepSubpartsTest {

    @Test
    public void Expected_MultiDeepSubpartTest() throws JAXBException, IOException {
        System.out.println("Expected_MultiDeepSubpartTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/subparts/Valid_MultiDeepSubpartsTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        FileOutputStream fout = new FileOutputStream("test/data/rdfout/Expected_MultiDeepSubpartTest.sbol.xml");


        SBOLFactory.write(Doc, fout);
        SBOLFactory.write(Doc, System.out);
        System.out.println(rsbpmlData);
        //TODO the output file here is incomplete
        fail("The test case is stub, no actual test.");
    }
}
