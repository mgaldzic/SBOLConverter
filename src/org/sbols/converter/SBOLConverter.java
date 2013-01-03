/*
 * This class converts source XML (rsbpml) defining individual parts registry biobricks (www.partsregistry.org)
 * into SBOL RDF/XML format.
 */
package org.sbols.converter;

import java.io.FileOutputStream;
import java.io.IOException;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.util.ReadRSBPML;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;

public class SBOLConverter {

    private SBOLConverter() {
    }

    private static void usage() {
        System.err.println("SBOLConverter version 0.1" /*
                 * SBOLVersion.getInstance().getVersionString()
                 */);
        System.err.println("Converts Parts Registry XML (RSBPML) to SBOL:Core:rdf.");
        System.err.println("\nUsage:");
        System.err.println("\tjava -jar SBOLConverter.jar [--quiet] <filename.xml> <outputname.xml>");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        String fileName = null;
        String outputName = null;

        if (args.length < 2 || args.length > 3) {
            usage();
        }

        boolean quiet = args[0].equals("--quiet");

        if (quiet && args.length == 2) {
            usage();
        }

        if (quiet && args.length == 3) {
            fileName = args[quiet ? 2 : 1];
        }

        if (!quiet && args.length == 2) {
            outputName = args[quiet ? 1 : 0];
        }

        try { //Can we enter this with fileName and outputName being null? Need to make sure

            Rsbpml rsbpmlData = ReadRSBPML.file(fileName + ".xml");
            FileOutputStream out = new FileOutputStream(outputName + ".txt");

            System.out.println(rsbpmlData);

            DnaComponent biobrick = SBOLFactory.createDnaComponent();
            SBOLDocument Doc = SBOLFactory.createDocument();
            biobrick = rsbpmlData.toSbol();
            Doc.addContent(biobrick);

            SBOLFactory.write(Doc, out);

        } catch (IOException e) {
            System.err.println("I/O ERROR: " + e.getMessage());
        } catch (SBOLValidationException e) {
            System.err.println("Validation failed, error: " + e.getMessage());
        }
    }
    public static SBOLDocument convert(Rsbpml rsbpmlData){
        SBOLDocument SbolDoc = SBOLFactory.createDocument();
        SbolDoc.addContent(rsbpmlData.toSbol());
        return SbolDoc;
        
    }
}
