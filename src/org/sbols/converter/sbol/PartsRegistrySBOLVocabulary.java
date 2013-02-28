/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.sbol;

import java.net.URI;

import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 *
 * @author mgaldzic
 */
public class PartsRegistrySBOLVocabulary {
    public static URI uri(String localName) {
		return NAMESPACE.resolve(localName);
	}
    private static ValueFactory FACTORY = ValueFactoryImpl.getInstance();
    
    
    public static final URI NAMESPACE = URI.create("http://partsregistry.org/type/");
    public static final org.openrdf.model.URI status = FACTORY.createURI("http://partsregistry.org/rsbpml/" + "status");
    
    
}


