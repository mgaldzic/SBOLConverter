package org.sbols.converter.rsbpml.subparts;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class Valid_DeepSubpartTest {

    @Test
    public void Valid_DeepSubpartTest() throws JAXBException, IOException {
        System.out.println("Valid_DeepSubpartTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/subparts/Valid_DeepSubpartTest.xml");

        SBOLDocument Doc = SBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
    }
}
