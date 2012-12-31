/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author mgaldzic
 */
public class WriteFile {

    public static void toPath(SBOLDocument SbolDoc, String file_out_path) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(file_out_path);
        SBOLFactory.write(SbolDoc, fout);
    }
}