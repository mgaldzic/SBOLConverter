package org.sbols.org.converter.rsbpml;

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

public class Test1_BasicValidPart {

    @Test
    public void test() throws JAXBException, IOException {
        System.out.println("Test1_BasicValidPart");
        Rsbpml rsbpmlData = ReadXML.file("test/data/Test1.xml");

        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);

    }
}
