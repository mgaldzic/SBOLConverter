package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbolstandard.core.DnaComponent;

@XmlRootElement(name = "specified_subscars")
public class specified_subscars {

    private subpart Subpart;

    @XmlElement(name = "subpart")
    public subpart getSubpart() {
        return Subpart;
    }

    public void setSubpart(subpart subpart) {
        this.Subpart = subpart;
    }

    public DnaComponent toSbol(DnaComponent biobrick) {
        biobrick = Subpart.toSbol(biobrick);
        return biobrick;
    }
}
