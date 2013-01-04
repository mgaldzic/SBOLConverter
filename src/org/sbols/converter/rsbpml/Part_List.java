/*
 * Defines leaves and classes within <part_list>
 */
package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;

@XmlRootElement(name = "part_list")
public class Part_List {

    private Part part;

    @XmlElement(name = "part")
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "part_list [" + (part != null ? part : "") + "]";
    }

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData) {
        return part.toSbol(biobrick, rsbpmlData);
    }
}
