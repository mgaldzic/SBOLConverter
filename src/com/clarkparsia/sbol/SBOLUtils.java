package com.clarkparsia.sbol;

import java.net.URI;
import java.util.UUID;


public class SBOLUtils {
	public static String toTitleCase(String input) {
    	StringBuilder titleCase = new StringBuilder();
    	boolean nextTitleCase = true;
    
    	for (int i = 0; i < input.length(); i++) {
    		char c = input.charAt(i);
    		if (Character.isSpaceChar(c)) {
    			nextTitleCase = true;
    		}
    		else if (nextTitleCase) {
    			c = Character.toTitleCase(c);
    			nextTitleCase = false;
    		}
    		else {
    			c = Character.toLowerCase(c);
    		}
    
    		titleCase.append(c);
    	}
    
    	return titleCase.toString();
    }

	/**
     * Returns a random, unique URI.
     */
    public static URI createURI() {
    	return URI.create("urn:" + UUID.randomUUID());
    }

	public static URI createURI(String uri) {
    	return uri == null || uri.length() == 0 ? createURI() : URI.create(uri);
    }
}
