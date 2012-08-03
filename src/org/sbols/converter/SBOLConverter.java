/*
 * This class converts source XML (rsbpml) defining individual parts registry biobricks (www.partsregistry.org)
 * into SBOL RDF/XML format.
 */

package org.sbols.converter;

import org.sbols.converter.rsbpml.Rsbpml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;

public class SBOLConverter {
	
	public static void main(String[] args) throws JAXBException, SBOLValidationException, IOException{
		
		JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rsbpml rsbpmlData = (Rsbpml)unmarshaller.unmarshal(new FileInputStream("test/data/Test1.xml"));
        FileOutputStream out = new FileOutputStream("out/output1.txt");
        
        System.out.println(rsbpmlData);
        
        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        SBOLDocument Doc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol();
        Doc.addContent(biobrick);
        
        SBOLFactory.write(Doc, out);
	}
	
}
