/*
 * Defines leaves and classes within <rsbpml>
 */

package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLFactory;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "rsbpml")
public class Rsbpml {

    Part_List part_list;

    @XmlElement(name = "part_list")
    public Part_List getPart_list() {
        return part_list;
    }

    public void setPart_list(Part_List part_list) {
        this.part_list = part_list;
    }

    @Override
    public String toString() {
        return "rsbpml [" + (part_list != null ? part_list : "") + "]";
    }

    public DnaComponent toSbol() {
        DnaComponent biobrick = SBOLFactory.createDnaComponent();
        return part_list.toSbol(biobrick);
    }
}
