/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbolstandard.core.SBOLDocument;

/**
 *
 * @author mgaldzic
 */
public class ReadFile {
    
    public static String normalize_ws (String aString){
        aString = aString.replaceAll("\\r\\n", "#@#@#");
        aString = aString.replaceAll("\\r", "#@#@#");
        aString = aString.replaceAll("\\n", "#@#@#");
        aString = aString.replaceAll("\\s+", " ");
        aString = aString.replaceAll("#@#@##@#@#", "#@#@#");
        aString = aString.replaceAll("#@#@#", "\n");
        String[] lines = aString.split("\n");
        //String[] lines = aString.split(System.getProperty("line.separator"));

        StringBuilder outString = new StringBuilder();
        for (String l : lines){
            outString.append(l.trim()).append("\n");
        }
        aString = outString.toString();
        return aString;
    }

    public static Boolean compare(String expected, String actual) {
        StringBuilder text_diff = new StringBuilder();
        Boolean isEqual = true;
        
        expected = normalize_ws(expected);
        actual = normalize_ws(actual);

        DiffMatchPatch dmp = new DiffMatchPatch();
        //LinkedList<DiffMatchPatch.Diff> diffs = dmp.diff_main(actual, expected, true);
        LinkedList<DiffMatchPatch.Diff> diffs = dmp.diff_lineMode(actual, expected);
        
        //dmp.diff_cleanupSemantic(diffs);

        for (DiffMatchPatch.Diff aDiff : diffs) {
            //System.out.println("adiff: " + aDiff);
            if (aDiff.operation != DiffMatchPatch.Operation.EQUAL) {
                text_diff.append(aDiff.operation);
                text_diff.append("ed '");
                text_diff.append(aDiff.text);
                text_diff.append("' found in Expected file\n");

                isEqual = false;
            }
        }
        System.out.println(isEqual == false ? "diffs: \n" + text_diff.toString() : "");
        return isEqual;

    }

    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static String fromPath(String filepath) throws FileNotFoundException {
        FileInputStream expected_fis = new FileInputStream(filepath);
        return convertStreamToString(expected_fis);
    }

    public static String sbolDocToString(SBOLDocument sboldoc) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PartsRegistrySBOLFactory.write(sboldoc, baos);
        return baos.toString();
    }
}
