/*
 * This class converts source XML (rsbpml) defining individual parts registry biobricks (www.partsregistry.org)
 * into SBOL RDF/XML format.
 */
package org.sbols.converter;

import java.io.FileOutputStream;
import java.io.IOException;
import org.sbols.converter.rsbpml.Rsbpml;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.util.ReadRSBPML;
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
        String inputFileName = null;
        String outputFileName = null;

        if (args.length < 2 || args.length > 3) {
            usage();
        }

        boolean quiet = args[0].equals("--quiet");

        if (quiet && args.length == 2) {
            usage();
        }

        if (quiet && args.length == 3) {
            inputFileName = args[1];
            outputFileName = args[2];
        }

        if (!quiet && args.length == 2) {
            inputFileName = args[0];
            outputFileName = args[1];

        }

        try { //Can we enter this with fileName and outputName being null? Need to make sure

            Rsbpml rsbpmlData = ReadRSBPML.file(inputFileName);
            FileOutputStream out = new FileOutputStream(outputFileName);

            //System.out.println(rsbpmlData);
           
            SBOLDocument Doc = convert(rsbpmlData);

            SBOLFactory.write(Doc, out);
        } catch (IOException e) {
            System.err.println("I/O ERROR: in: " + inputFileName + " out: " + outputFileName + ", " + e.getMessage());
        } catch (SBOLValidationException e) {
            System.err.println("Validation failed " + inputFileName + ", error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception " + inputFileName + ", error: " + e.getClass().getName()+" "+ e.getMessage());
        }
        System.out.println("Processed in: " + inputFileName + " out: " + outputFileName);
        
    }

    public static SBOLDocument convert(Rsbpml rsbpmlData) throws SBOLValidationException {
        PartsRegistryDnaComponent biobrick = PartsRegistrySBOLFactory.createDnaComponent();
        SBOLDocument SbolDoc = SBOLFactory.createDocument();
        biobrick = rsbpmlData.toSbol(biobrick, rsbpmlData);
        SbolDoc.addContent(biobrick);
        //PartsRegistrySBOLFactory.validate(SbolDoc);
        return SbolDoc;

    }
}
