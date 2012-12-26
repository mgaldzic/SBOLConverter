package org.sbols.org.converter.rsbpml;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadXML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Test5_BasicPartwithSOType {

    @Test
    public void test() throws JAXBException, IOException {
        System.out.println("Test5_BasicPartwithSOType");
        Rsbpml rsbpmlData = ReadXML.file("test/data/Test5.xml");

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
