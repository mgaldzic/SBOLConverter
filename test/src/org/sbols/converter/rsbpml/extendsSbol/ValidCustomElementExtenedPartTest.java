/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.extendsSbol;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.SBOLConverter;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class ValidCustomElementExtenedPartTest {
    @Test
    public void ValidCustomElementExtenedPartTest() throws JAXBException, FileNotFoundException {
        System.out.println("ValidCustomElementExtenedPartTest");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/extendsSBOL/ValidCustomElementExtenedPartTest.xml");
        SBOLDocument SbolDoc = SBOLConverter.convert(rsbpmlData);
        SBOLFactory.validate(SbolDoc);
    }
}
