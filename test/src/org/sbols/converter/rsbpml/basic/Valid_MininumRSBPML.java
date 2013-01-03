/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml.basic;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;

/**
 *
 * @author mgaldzic
 */
public class Valid_MininumRSBPML {
    @Test
    public void Valid_MininumRSBPML() throws JAXBException, IOException {
        System.out.println("Valid_MininumRSBPML");
        Rsbpml rsbpmlData = ReadRSBPML.file("test/data/basic/Valid_MininumRSBPML.xml");

        SBOLDocument Doc = PartsRegistrySBOLFactory.createDocument();
        DnaComponent biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        PartsRegistrySBOLFactory.validate(Doc);
    }
}
