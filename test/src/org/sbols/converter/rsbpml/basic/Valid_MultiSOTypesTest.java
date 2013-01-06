package org.sbols.converter.rsbpml.basic;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;

public class Valid_MultiSOTypesTest {

    @Test
    public void Valid_MultiSOTypesTest() throws JAXBException, IOException {
        System.out.println("Valid_MultiSOTypesTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/basic/MultiSOTypes_Test.xml");

        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        PartsRegistrySBOLFactory.validate(SbolDoc);
    }
}
