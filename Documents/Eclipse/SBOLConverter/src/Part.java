	/*
	 * Defines contents of <part>
	 */

	import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbolstandard.core.DnaComponent;

	@XmlRootElement(name="part")
	public class Part {
		
		private String part_id;
		private String part_name;
		private String part_short_name;
		
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	    @XmlElement(name="part_id")
	    public String getPart_id() {
	        return part_id;
	    }

	    public void setPart_id(String part_id) {
	        this.part_id = part_id;
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
	    @XmlElement(name="part_short_name")
	    public String getPart_short_name() {
	        return part_short_name;
	    }

	    public void setPart_short_name(String part_short_name) {
	        this.part_short_name = part_short_name;
	    }
	    
	    @Override
	    public String toString() {
	        return "part [" + 
	        			(part_id != null ? "part_id: " + part_id + ", " : "") + 
	        			(part_name != null ? "part_name: " + part_name + ", " : "") + 
	        			(part_short_name != null ? "part_short_name: " + part_short_name: "")
	        		 + "]";
	    }
	    
	    public DnaComponent toSbol(DnaComponent biobrick) {
	    	biobrick.setDisplayId(part_name);
			return biobrick;
	    }

	}

