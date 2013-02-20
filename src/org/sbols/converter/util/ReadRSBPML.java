/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.sbols.converter.rsbpml.Rsbpml;

/**
 *
 * @author mgaldzic
 */
public class ReadRSBPML {
    public static Rsbpml file (String path) throws JAXBException, FileNotFoundException{
    JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rsbpml rsbpmlData = (Rsbpml) unmarshaller.unmarshal(new FileInputStream(path));

        return rsbpmlData;
    }
<<<<<<< HEAD
=======
    
    /**
     * This method ensures that the output String has only
     * valid XML unicode characters as specified by the
     * XML 1.0 standard. For reference, please see
     * <a href="http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char">the
     * standard</a>. This method will return an empty
     * String if the input is null or empty.
     *
     * @param in The String whose non-valid characters we want to remove.
     * @return The in String, stripped of non-valid characters.
     */
    public static String stripNonValidXMLCharacters(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in))) return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            System.out.println(current);  
            if ((current == 0x9) ||
                (current == 0xA) ||
                (current == 0xD) ||
                ((current >= 0x20) && (current <= 0xD7FF)) ||
                ((current >= 0xE000) && (current <= 0xFFFD)) ||
                ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }    
    public static String removeInvalidXMLCharacters(String s) {

    	StringBuffer out = new StringBuffer();
        int codePoint;
        Integer i = 0;

        if (s == null || ("".equals(s))) return ""; // vacancy test.
        for (i = 0; i < s.length(); i++) {
            codePoint = s.codePointAt(i);
            if ((codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF))) {
                out.append(Character.toChars(codePoint));
            }

        }
        return out.toString();
    }
>>>>>>> refs/heads/newlibSBOLj
}
