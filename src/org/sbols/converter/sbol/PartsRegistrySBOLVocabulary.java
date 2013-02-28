/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.sbol;

import org.openrdf.model.URI;

import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 *
 * @author mgaldzic
 */
public class PartsRegistrySBOLVocabulary {
	
	private static ValueFactory FACTORY = ValueFactoryImpl.getInstance();
	
    public static java.net.URI typeUri(String localName) {
		return TYPE_NAMESPACE.resolve(localName);
	}
	private static final URI uri(String ns, String localName) {
		return FACTORY.createURI(ns + localName);
	}
    
    public static final String REGISTRY_NAMESPACE = "http://partsregistry.org/rsbpml/";
    public static final java.net.URI TYPE_NAMESPACE = java.net.URI.create("http://partsregistry.org/type/");
    
    public static final URI status = uri(REGISTRY_NAMESPACE, "status");
    //public static final URI author = rsbpmlUri(REGISTRY_NAMESPACE, "author");
    
}


