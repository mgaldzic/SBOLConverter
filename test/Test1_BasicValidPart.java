/*
 * Tests the converter succesfully converts the simplest dna component, containing just a name.
 */

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;


public class Test1_BasicValidPart {

	@Test
	public void test() throws JAXBException, SBOLValidationException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rsbpml rsbpmlData = (Rsbpml)unmarshaller.unmarshal(new FileInputStream("test/data/Test1.xml"));
        //FileOutputStream out = new FileOutputStream("out/output3.txt");
                
        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
        
        }
}
