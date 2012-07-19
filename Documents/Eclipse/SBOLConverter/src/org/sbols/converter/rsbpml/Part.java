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
	    
	    @Override
	    public String toString() {
	        return "part [" + 
	        			(part_name != null ? "part_name: " + part_name + ", " : "") + 
	        			(part_nickname != null ? "part_nickname: " + part_nickname + ", " : "") + 
	        			(part_short_desc != null ? "part_short_desc: " + part_short_desc: "") +
	        			(dna_sequence != null ? "dna_sequence: " + dna_sequence: "")
	        		 + "]";
	    }
	    
	    public DnaComponent toSbol(DnaComponent biobrick) {
	    	biobrick.setURI(URI.create("http://example.com/MyDnaComponent")); //Need to make dynamic
	    	biobrick.setDisplayId(part_name);
	    	biobrick.setDescription(part_short_desc);
	    	biobrick.setName(part_nickname);
			return dna_sequence.toSbol(biobrick);
	    }

	}

