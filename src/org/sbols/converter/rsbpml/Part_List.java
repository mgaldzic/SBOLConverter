/*
 * Defines leaves and classes within <part_list>
 */
package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbols.converter.sbol.PartsRegistryDnaComponent;

@XmlRootElement(name = "part_list")
public class Part_List {

    private Part part;
    private String error;

    @XmlElement(name = "part")
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "ERROR")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "part_list [" + (part != null ? part : "") + "]";
    }

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData) {
    	if (error != null){
    		throw new RsbpmlException(error.toString()); 
    	}
        return part.toSbol(biobrick, rsbpmlData);
    }
}
