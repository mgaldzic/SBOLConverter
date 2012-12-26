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
public class ReadXML {
    public static Rsbpml file (String path) throws JAXBException, FileNotFoundException{
    JAXBContext context = JAXBContext.newInstance(Rsbpml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Rsbpml rsbpmlData = (Rsbpml) unmarshaller.unmarshal(new FileInputStream(path));

        return rsbpmlData;
    }
}
