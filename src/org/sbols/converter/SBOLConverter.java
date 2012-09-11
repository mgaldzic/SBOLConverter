/*
 * This class converts source XML (rsbpml) defining individual parts registry biobricks (www.partsregistry.org)
 * into SBOL RDF/XML format.
 */

package org.sbols.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.sbols.converter.rsbpml.Rsbpml;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;

public class SBOLConverter {
		
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
 * public class SBOLValidate {
private SBOLValidate() {	
}

private static void usage() {	
System.err.println("libSBOLj version " + SBOLVersion.getInstance().getVersionString());
System.err.println("Description: Validates the contents of an SBOL document and prints the document contents if "
+ "validation succeeds");
System.err.println("Usage:");
System.err.println("\tjava --jar libSBOLj.jar [--quiet] <filename.xml>");
System.exit(1);
}

public static void main(String[] args) throws Exception {
if (args.length < 1 || args.length > 2) {
usage();
}

boolean quiet = args[0].equals("--quiet");

if (quiet && args.length == 1) {
usage();
}

String fileName = args[quiet ? 1 : 0];

try {
SBOLDocument doc = SBOLFactory.read(new FileInputStream(fileName));
System.out.println("Validation successful, no errors.");
if (!quiet) {
new SBOLPrettyWriter().write(doc, System.out);
}
        }
        catch (IOException e) {
System.err.println("I/O ERROR: " + e.getMessage());
        }
        catch (SBOLValidationException e) {
         System.err.println("Validation failed, error: " + e.getMessage());
        }
}
}
 */
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
