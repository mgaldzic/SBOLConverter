import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;


public class Test4_BasicPartwithBasicSubpart {

	@Test
	public void test() throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rsbpml rsbpmlData = (Rsbpml)unmarshaller.unmarshal(new FileInputStream("test/data/Test4.xml"));
        
        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        SBOLFactory.validate(Doc);
        
        FileOutputStream out = new FileOutputStream("output4.txt");
        SBOLFactory.write(Doc, out);
        System.out.println(rsbpmlData);
	}
	
}
