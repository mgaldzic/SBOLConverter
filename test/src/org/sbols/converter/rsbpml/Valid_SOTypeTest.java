package org.sbols.converter.rsbpml;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_SOTypeTest {

    @Test
    public void Valid_05_SOTypeTest() throws JAXBException, IOException {
        System.out.println("Valid_SOTypeTest");
        Rsbpml rsbpmlData = ReadXML.file("test/data/Valid_SOTypeTest.xml");

        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);

        //Remove this later
        FileOutputStream out = new FileOutputStream("output5.txt");
        SBOLFactory.write(Doc, out);
        System.out.println(rsbpmlData);
    }
}