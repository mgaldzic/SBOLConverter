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
public class subpart {

    private String part_name;
    private String part_nickname;
    private String part_short_desc;

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

    public DnaComponent toSbol(DnaComponent biobrick) {
        DnaComponent SubDnaComponent = SBOLFactory.createDnaComponent();
        SubDnaComponent.setURI(URI.create("http://example.com/MyDnaComponent1")); //Need to make dynamic
        SubDnaComponent.setDisplayId(part_name);
        SubDnaComponent.setDescription(part_short_desc);
        SubDnaComponent.setName(part_nickname);
        SequenceAnnotation newAnnotation = SBOLFactory.createSequenceAnnotation();
        newAnnotation.setSubComponent(SubDnaComponent);
        newAnnotation.setURI(URI.create("http://sampleuri.com/NewAnnotation"));
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
}
