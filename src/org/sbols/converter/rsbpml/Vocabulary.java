/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.rsbpml;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//import org.openrdf.model.URI;
//import org.openrdf.model.ValueFactory;
//import org.openrdf.model.impl.ValueFactoryImpl;

/**
 *
 * @author mgaldzic
 */
public class Vocabulary {

    
/*
    private static ValueFactory FACTORY = ValueFactoryImpl.getInstance();
    //Namespace of the Sequence Ontology (<a href="http://purl.obolibrary.org/obo/">http://purl.obolibrary.org/obo/</a>)
    public static final String NAMESPACE = "http://sbols.org/v1#";
    private static URI uri(String localName) {
        return FACTORY.createURI(NAMESPACE + localName);
    }
*/
    public static URI uri(String localName) {
		return NAMESPACE.resolve(localName);
	}
    public static final URI NAMESPACE = URI.create("http://purl.obolibrary.org/obo/");
    //SequenceOntology
    public static final URI PROMOTER = uri("SO_0000167");
    public static final URI CONSERVED = uri("SO_0000856");
    public static final URI REGULATORY_REGION = uri("SO_0005836");
    public static final URI SILENT_MUTATION = uri("SO_0001017");
    public static final URI STEM_LOOP = uri("SO_0000313");
    public static final URI TERMINATOR = uri("SO_0000141");
    public static final URI BINDING_SITE = uri("SO_0000409");
    public static final URI SEQUENCE_VARIANT = uri("SO_0001060");
    public static final URI OPERATOR = uri("SO_0000057");
    public static final URI PLASMID = uri("SO_0000155");
    public static final URI PRIMER = uri("SO_0000112");
    public static final URI PRIMER_BINDING_SITE = uri("SO_0005850");
    public static final URI POLYPEPTIDE = uri("SO_0000104");
    public static final URI POLYPEPTIDE_DOMAIN = uri("SO_0000417");
    public static final URI CODING_START = uri("SO_0000323");
    public static final URI CODING_END = uri("SO_0000327");
    public static final URI TAG = uri("SO_0000324");
    public static final URI CDS = uri("SO_0000316");
    public static final URI POLYA_SITE = uri("SO_0000553");
    public static final URI RIBOSOME_ENTRY_SITE = uri("SO_0000139");
    
    //Create a mapping from Registry vocab to SO
    public static final Map<String, URI> SO_MAP = createMap();

    private static Map<String, URI> createMap() {
        Map<String, URI> map = new HashMap<>();
        map.put("promoter", PROMOTER);
        map.put("conserved", CONSERVED);
        map.put("regulatory", REGULATORY_REGION);
        map.put("s_mutation", SILENT_MUTATION);
        map.put("stem_loop", STEM_LOOP);
        map.put("terminator", TERMINATOR);
        map.put("binding", BINDING_SITE);
        map.put("mutation", SEQUENCE_VARIANT);
        map.put("operator", OPERATOR);
        map.put("plasmid", PLASMID);
        map.put("plasmid_backbone", PLASMID);
        map.put("primer", PRIMER);
        map.put("primer_binding", PRIMER_BINDING_SITE);
        map.put("protein", POLYPEPTIDE);
        map.put("protein_domain", POLYPEPTIDE_DOMAIN);
        map.put("start", CODING_START);
        map.put("stop", CODING_END);
        map.put("tag", TAG);
        map.put("cds", CDS);
        map.put("polya", POLYA_SITE);
        map.put("rbs", RIBOSOME_ENTRY_SITE);
        return Collections.unmodifiableMap(map);
    }
}
