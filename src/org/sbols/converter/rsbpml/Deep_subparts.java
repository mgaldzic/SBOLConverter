package org.sbols.converter.rsbpml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbolstandard.core.DnaComponent;

@XmlRootElement(name = "deep_subparts")
public class Deep_subparts {

    private List<Subpart> subpart;
    
    public Deep_subparts (){
        subpart = new ArrayList<>();
    }
    
    @XmlElement(name = "subpart")
    public List<Subpart> getSubpart() {
        if (subpart == null) {
            subpart = new ArrayList<>();
        }
        return subpart;
    }

    public void setSubpart(List<Subpart> subpart) {
        this.subpart = subpart;
    }
    
    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\ndeep_subparts [\n"
                + (subpart != null ? "subpart: " + subpart + ", \n" : "")
                + "subpart length: |" + subpart.size() + "| \n";
    }
    public DnaComponent toSbol(DnaComponent biobrick) {
        if (subpart != null) {
            for (Subpart aSubpart : subpart)  {
                biobrick = aSubpart.toSbol(biobrick);
            }
        } 
        return biobrick;
    }
}
