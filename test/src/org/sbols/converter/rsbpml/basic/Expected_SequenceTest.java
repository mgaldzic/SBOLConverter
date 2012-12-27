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
 *
 * @author mgaldzic
 */
public class Expected_SequenceTest {
    @Test
    public void Expected_SequenceTest() throws JAXBException, IOException {
        System.out.println("Expected_SequenceTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_SequenceTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
        FileOutputStream out = new FileOutputStream("test/data/rdfout/Expected_SequenceTest.sbol.xml");
        //TODO the output file here is incomplete
        SBOLFactory.write(Doc, out);
        fail("The test case is stub, no actual test.");
    }
}
