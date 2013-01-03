package org.sbols.converter.rsbpml.basic;

/*
 * Tests the converter successfully converts the simplest dna component,
 * containing just a name.
 */
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;

public class Valid_BasicPartTest {

    @Test
    public void Valid_BasicPartTest() throws JAXBException, IOException {
        System.out.println("Valid_BasicPartTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/basic/Valid_BasicPartTest.xml");

        SBOLDocument Doc = SBOLConverter.convert(rsbpmlData);
        PartsRegistrySBOLFactory.validate(Doc);

    }
}
