package org.sbols.converter.rsbpml.basic;

/*
 * Tests the converter successfully converts the simplest dna component,
 * containing just a name.
 */
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_BasicPartTest {

    @Test
    public void Valid_BasicPartTest() throws JAXBException, IOException {
        System.out.println("Valid_BasicPartTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_BasicPartTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);

    }
}
