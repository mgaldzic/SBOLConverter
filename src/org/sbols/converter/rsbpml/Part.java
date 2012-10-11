	/*
	 * Defines contents of <part>
	 */

    package org.sbols.converter.rsbpml;
	import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbolstandard.core.DnaComponent;

	@XmlRootElement(name="part")
	public class Part {
		
		private dnaSequenceContainer dna_sequence;
		private String part_name;
		private String part_nickname;
		private String part_short_desc;
		private subpart specifiedSubparts;
		private deep_subparts deepSubparts;
		private subpart specifiedSubscars;

		
		
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
	    
	    /*Here are the things I am making up*/
	    //split into three different functions
	    //need to define precedes
	    @XmlElement(name="deep_subparts")
		public deep_subparts getDeepSubparts(){
			return deepSubparts;
		}
		
		public void setDeepSubparts(deep_subparts newSubpart){
			this.deepSubparts = newSubpart;
		}
		/*
		@XmlElement(name="specified_subparts")
		public subpart getSpecifiedSubpart(){
			return specifiedSubparts;
		}
		
		public void setSpecifiedSubparts(subpart newSubpart){
			this.specifiedSubparts = (newSubpart);
		}
		
		  @XmlElement(name="specified_subscars")
		public ArrayList<subpart> getSpecifiedSubscars(){
			return specifiedSubscars;
		}
		
		public void setSpecifiedSubscars(subpart newSubpart){
			this.specifiedSubscars.add(newSubpart);
		}
		*/
		/////////////////////
	     
	    /*End of things I am making up*/
		
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
	    	/*
	    	if(specifiedSubparts != null){
	    		for(int i = 0; i < specifiedSubparts.size(); i++){
	    			biobrick = specifiedSubparts.get(i).addSubcomponent(biobrick);
	    		}
	    	}*/if(deepSubparts != null){
	    		//for(int i = 0; i < deepSubparts.size(); i++){
	    		biobrick = deepSubparts.toSbol(biobrick);
	    		//}
	    	}/*if(specifiedSubscars != null){
	    		for(int i = 0; i < specifiedSubscars.size(); i++){
	    			biobrick = specifiedSubscars.get(i).addSubcomponent(biobrick);
	    		}
	    	}*/
	    	if(dna_sequence!=null){
	    		biobrick =  dna_sequence.toSbol(biobrick);
	    	}
	    	return biobrick;
	    }

	}

