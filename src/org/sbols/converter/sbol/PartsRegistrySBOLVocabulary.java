/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.sbol;

import java.net.URI;

/**
 *
 * @author mgaldzic
 */
public class PartsRegistrySBOLVocabulary {
    public static URI uri(String localName) {
		return NAMESPACE.resolve(localName);
	}
    public static final URI NAMESPACE = URI.create("http://partsregistry.org/type/");
    
}
