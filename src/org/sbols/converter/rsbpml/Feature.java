package org.sbols.converter.rsbpml;

import java.net.URI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.StrandType;

@XmlRootElement(name = "feature")
public class Feature {

    private String id;
    private String title;
    private String type;
    private String direction;
    private String startpos;
    private String endpos;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "startpos")
    public String getStartpos() {
        return startpos;
    }

    public void setStartpos(String startpos) {
        this.startpos = startpos;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "endpos")
    public String getEndpos() {
        return endpos;
    }

    public void setEndpos(String endpos) {
        this.endpos = endpos;
    }

    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\nfeature [\n"
                + (title != null ? "title: " + title + ", \n" : "")
                + (type != null ? "type: " + type + ", \n" : "")
                + (direction != null ? "direction: " + direction + ", \n" : "");
    }

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick) {
        PartsRegistryDnaComponent feature = PartsRegistrySBOLFactory.createDnaComponent();
        feature.setURI(URI.create("http://partsregistry.org/feat/f_" + id)); //TODO Need to make dynamic
        feature.setDisplayId("f_" + id);
        feature.setName(title);
        feature.addType(Vocabulary.SO_MAP.get(type));
        SequenceAnnotation newAnnotation = SBOLFactory.createSequenceAnnotation();
        newAnnotation.setSubComponent(feature);
        newAnnotation.setURI(URI.create("http://partsregistry.org/anot/f_" + id)); //TODO other feature cases 
        newAnnotation.setBioStart(Integer.parseInt(startpos));
        newAnnotation.setBioEnd(Integer.parseInt(endpos));
        if (direction != null) {
            if (direction.equals("forward")){
            newAnnotation.setStrand(StrandType.POSITIVE);
            }
            if (direction.equals("reverse")){
            newAnnotation.setStrand(StrandType.NEGATIVE);
            }  
        }   
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
}
