package com.clarkparsia.sbol;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * Vocabulary terms used by the official SBOL serialization.
 * 
 * @author Evren Sirin
 */
public class SBOLVocabulary {
	private SBOLVocabulary() {
	}
	
	private static ValueFactory FACTORY = ValueFactoryImpl.getInstance();

	
	public static final String NAMESPACE = "http://sbols.org/v1#";

	private static final URI uri(String localName) {
		return FACTORY.createURI(NAMESPACE + localName);
	}

	public static final URI DnaComponent = uri("DnaComponent");
	public static final URI displayId = uri("displayId");
	public static final URI name = uri("name");
	public static final URI description = uri("description");
	public static final URI dnaSequence = uri("dnaSequence");
	public static final URI annotation = uri("annotation");
	public static final URI DnaSequence = uri("DnaSequence");
	public static final URI nucleotides = uri("nucleotides");
	
	public static final URI SequenceAnnotation = uri("SequenceAnnotation");
	public static final URI precedes = uri("precedes");
	public static final URI bioStart = uri("bioStart");
	public static final URI bioEnd = uri("bioEnd");
	public static final URI strand = uri("strand");
	public static final URI subComponent = uri("subComponent");
	
	public static final URI Collection = uri("Collection");
	public static final URI component = uri("component");
	
	
}
