package org.sbols.converter.rsbpml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.sbol.PartsRegistrySBOLVocabulary;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLValidationException;
import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.StrandType;

@XmlRootElement(name = "feature")
public class Feature {

    private String id;
    private String title;
    //private String type;
    private List<String> types = new ArrayList<>();
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
    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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

    private PartsRegistryDnaComponent assignType(PartsRegistryDnaComponent feature) {
        if (types != null) {

            for (String aType : types) {
                aType = aType.toLowerCase();
                if (Vocabulary.SO_MAP.get(aType) != null) {
                    feature.addType(Vocabulary.SO_MAP.get(aType));
                }
                feature.addRegistry_types(PartsRegistrySBOLVocabulary.uri(aType));
            }
        }
        return feature;
    }

    private PartsRegistryDnaComponent assignPartFeature(PartsRegistryDnaComponent biobrick) {
        PartsRegistryDnaComponent feature = PartsRegistrySBOLFactory.createDnaComponent();

        //title = title.trim(); - loooks like traling spaces are already taken care of
        feature.setURI(URI.create("http://partsregistry.org/part/" + title));

        if (biobrick.getAnnotations().size() > 0) { //Actual annotations already exist
            for (SequenceAnnotation subpartSA : biobrick.getAnnotations()) { //any of them
                if (!feature.getURI().equals(subpartSA.getSubComponent().getURI())) { //NOT Already a *Subpart  
                    feature.setDisplayId(title);
                }
            }
        } else { //only features in this one
            feature.setDisplayId(title);
        }


        feature = assignType(feature);
        return feature;
    }

    private PartsRegistryDnaComponent assignNotPartFeature() {
        PartsRegistryDnaComponent feature = PartsRegistrySBOLFactory.createDnaComponent();
        feature.setURI(URI.create("http://partsregistry.org/feat/f_" + id));
        feature.setDisplayId("f_" + id);
        if (title != null) {
            feature.setName(title);
        } else {
            feature.setName(types.get(0).toLowerCase());
        }
        feature = assignType(feature);
        return feature;
    }

    private SequenceAnnotation assignAnnotation(SequenceAnnotation newAnnotation) throws SBOLValidationException {
        newAnnotation.setURI(URI.create("http://partsregistry.org/anot/f_" + id));
        Integer expectedLength = Integer.parseInt(endpos) - Integer.parseInt(startpos) + 1;
        if (!(expectedLength > 0)) {
            throw new SBOLValidationException("Inconsistent startpos and endpos rsbpml.Feature values");
        }

        newAnnotation.setBioStart(Integer.parseInt(startpos));
        newAnnotation.setBioEnd(Integer.parseInt(endpos));
        if (direction != null) {
            if (direction.equals("forward")) {
                newAnnotation.setStrand(StrandType.POSITIVE);
            }
            if (direction.equals("reverse")) {
                newAnnotation.setStrand(StrandType.NEGATIVE);
            }
        }
        return newAnnotation;
    }

    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\nfeature [\n"
                + (title != null ? "title: " + title + ", \n" : "")
                + (types != null ? "types: " + types + ", \n" : "")
                + (direction != null ? "direction: " + direction + ", \n" : "");
    }

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int position) throws SBOLValidationException{
        PartsRegistryDnaComponent feature;

        if (title != null && title.startsWith("BBa_")) {
            feature = assignPartFeature(biobrick);
        } else {
            feature = assignNotPartFeature();
        }

        SequenceAnnotation newAnnotation = SBOLFactory.createSequenceAnnotation();
        newAnnotation.setSubComponent(feature);
        newAnnotation = assignAnnotation(newAnnotation);
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
}
