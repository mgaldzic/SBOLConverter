/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbolstandard.core.SBOLDocument;


/**
 *
 * @author mgaldzic
 */
public class WriteFile {

    public static void toPath(SBOLDocument SbolDoc, String file_out_path) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(file_out_path);
        PartsRegistrySBOLFactory.write(SbolDoc, fout);
    }
}