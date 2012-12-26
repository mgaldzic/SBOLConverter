/*
 * Defines contents of <part>
 */

package org.sbols.converter.rsbpml;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbolstandard.core.DnaComponent;

@XmlRootElement(name="part")
public class Part {
		
		private static final String soURI = "http://purl.obolibrary.org/obo/";
		private static final Map<String,String> SOtypes = setSOtypes();
		
		private dnaSequenceContainer dna_sequence;
		private String part_name;
		private String part_nickname;
		private String part_short_desc;
		private deep_subparts deepSubparts;
		private ArrayList<String> types;
		
		public static Map<String, String> setSOtypes(){
			Map<String,String> SOtypes = new HashMap<String,String>();
			SOtypes.put("promoter",soURI + "SO_0000167");
			SOtypes.put("bidirectional_promoter",soURI + "SO_0000568");
			return SOtypes;
		}
		
		@XmlElement(name="dnaSequence")
		public dnaSequenceContainer getSequence(){
			return dna_sequence;
		}
		
		public void setSequence(dnaSequenceContainer newSequence){
			this.dna_sequence = newSequence;
		}
		
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	    @XmlElement(name="part_name")
	    public String getPart_name() {
	        return part_name;
	    }

	    public void setPart_name(String part_name) {
	        this.part_name = part_name;
	    }
		    
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	    @XmlElement(name="part_nickname")
	    public String getPart_nickname() {
	        return part_nickname;
	    }

	    public void setPart_nickname(String part_nickname) {
	        this.part_nickname = part_nickname;
	    }
	    
	    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	    @XmlElement(name="part_short_desc")
	    public String getPart_short_desc() {
	        return part_short_desc;
	    }

	    public void setPart_short_desc(String part_short_desc) {
	        this.part_short_desc = part_short_desc;
	    }
	    
	    @XmlElement(name="deep_subparts")
		public deep_subparts getDeepSubparts(){
			return deepSubparts;
		}
		
		public void setDeepSubparts(deep_subparts newSubpart){
			this.deepSubparts = newSubpart;
		}

		@XmlElement(name="type")
		public ArrayList<String> getType (){
			return types;
		}
		
		public void setType (String newType){
			this.types.add(newType);
		}
		
	    @Override //need to edit this later to reflect changes
	    public String toString() {
	        return "part [" + 
	        			(part_name != null ? "part_name: " + part_name + ", " : "") + 
	        			(part_nickname != null ? "part_nickname: " + part_nickname + ", " : "") + 
	        			(part_short_desc != null ? "part_short_desc: " + part_short_desc: "") +
	        			(dna_sequence != null ? "dna_sequence: " + dna_sequence: "")
	        		 + "]" + "HEY, the length of the subpart list is" + deepSubparts;
	    }
	    
	    public DnaComponent toSbol(DnaComponent biobrick) {
	    	biobrick.setURI(URI.create("http://example.com/MyDnaComponent")); //Need to make dynamic
	    	biobrick.setDisplayId(part_name);
	    	biobrick.setDescription(part_short_desc);
	    	biobrick.setName(part_nickname);
	    	
	    	if(types!=null){
		    	for(int i = 0; i < types.size(); i++){
		    	String tempType = SOtypes.get(types.get(i));
		    	biobrick.addType(URI.create(tempType));
		    	}
	    	}

	    	if(dna_sequence!=null){
	    		biobrick =  dna_sequence.toSbol(biobrick);
	    	}
	    	
	    	return biobrick;
	    }

}

