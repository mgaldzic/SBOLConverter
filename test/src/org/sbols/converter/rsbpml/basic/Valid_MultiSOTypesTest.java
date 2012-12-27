package org.sbols.converter.rsbpml.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_MultiSOTypesTest {

    @Test
    public void Valid_MultiSOTypesTest() throws JAXBException, IOException {
        System.out.println("Valid_MultiSOTypesTest");
                Rsbpml rsbpmlData = ReadXML.file("test/data/basic/Valid_MultiSOTypesTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}