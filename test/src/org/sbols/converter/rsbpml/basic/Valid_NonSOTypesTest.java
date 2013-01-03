package org.sbols.converter.rsbpml.basic;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;

public class Valid_NonSOTypesTest {

    @Test
    public void Valid_NonSOTypesTest() throws JAXBException, IOException {
        System.out.println("Valid_NonSOTypesTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_NonSOTypesTest.xml");

        SBOLDocument Doc = PartsRegistrySBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        PartsRegistrySBOLFactory.validate(Doc);
    }
}
