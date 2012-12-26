package org.sbols.org.converter.rsbpml;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Test3_BasicPartWithSequenceData {

    @Test
    public void test() throws JAXBException, IOException {
        System.out.println("Test3_BasicPartWithSequenceData");
        Rsbpml rsbpmlData = ReadXML.file("test/data/Test3.xml");

        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);

    }
}
