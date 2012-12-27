package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbolstandard.core.DnaComponent;

@XmlRootElement(name = "deep_subparts")
public class Deep_subparts {

    private Subpart Subpart;

    @XmlElement(name = "subpart")
    public Subpart getSubpart() {
        return Subpart;
    }

    public void setSubpart(Subpart subpart) {
        this.Subpart = subpart;
    }

    public DnaComponent toSbol(DnaComponent biobrick) {
        biobrick = Subpart.toSbol(biobrick);
        return biobrick;
    }
}
