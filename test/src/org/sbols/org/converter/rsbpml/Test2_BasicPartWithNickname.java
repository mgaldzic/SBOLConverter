package org.sbols.org.converter.rsbpml;

import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Test2_BasicPartWithNickname {

    @Test
    public void test() throws JAXBException, IOException {
        System.out.println("Test2_BasicPartWithNickname");
        Rsbpml rsbpmlData = ReadXML.file("test/data/Test2.xml");

        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}
