package org.sbols.converter.rsbpml;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SequenceAnnotation;

@XmlRootElement(name = "subpart")
public class Subpart extends SubThing{

    private String part_id;
    private String part_name;
    private String part_nickname;
    private String part_short_desc;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "part_id")
    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }
    
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "part_name")
    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "part_nickname")
    public String getPart_nickname() {
        return part_nickname;
    }

    public void setPart_nickname(String part_nickname) {
        this.part_nickname = part_nickname;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "part_short_desc")
    public String getPart_short_desc() {
        return part_short_desc;
    }

    public void setPart_short_desc(String part_short_desc) {
        this.part_short_desc = part_short_desc;
    }

    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\nsubpart [\n"
                + (part_name != null ? "part_name: " + part_name + ", \n" : "")
                + (part_short_desc != null ? "part_short_desc: " + part_short_desc + ", \n" : "")
                + (part_nickname != null ? "part_nickname: " + part_nickname + ", \n" : "")                ;
    }

    public DnaComponent toSbol(DnaComponent biobrick) {
        DnaComponent SubDnaComponent = SBOLFactory.createDnaComponent();
        SubDnaComponent.setURI(URI.create("http://partsregistry.org/part/" + part_name)); //TODO Need to make dynamic
        SubDnaComponent.setDisplayId(part_name);
        SubDnaComponent.setDescription(part_short_desc);
        SubDnaComponent.setName(part_nickname);
        SequenceAnnotation newAnnotation = SBOLFactory.createSequenceAnnotation();
        newAnnotation.setSubComponent(SubDnaComponent);
        newAnnotation.setURI(URI.create("http://partsregistry.org/anot/an_"+part_id)); //TODO parent part_id+_+part_id+_+posiiton 
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
}
