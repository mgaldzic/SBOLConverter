/*
 * Defines contents of <part>
 */
package org.sbols.converter.rsbpml;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbols.converter.sbol.PartsRegistrySBOLVocabulary;
import org.sbolstandard.core.DnaSequence;
import org.sbolstandard.core.SBOLValidationException;
import org.sbolstandard.core.SequenceAnnotation;

@XmlRootElement(name = "part")
public class Part {

    private String part_id;
    private String part_name;
    //short_name
    private String part_short_desc;
    private List<String> part_types = new ArrayList<>();
    //status
    //results
    private String part_nickname;
    //url
    //entered
    //author
    //quality
    private List<DeepSubpart> deep_subparts;
    private List<SpecifiedSubpart> specified_subparts;
    private List<SpecifiedSubscar> specified_subscars;
    private List<Feature> features;
    private List<String> seq_data = new ArrayList<>();
    private List<Category> categories;
    //features
    //paramters
    //categories  

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
    @XmlElement(name = "part_short_desc")
    public String getPart_short_desc() {
        return part_short_desc;
    }

    public void setPart_short_desc(String part_short_desc) {
        this.part_short_desc = part_short_desc;
    }

    @XmlElement(name = "part_type")
    public List<String> getPartTypes() {
        return part_types;
    }

    public void setPartTypes(List<String> newPartTypes) {
        this.part_types = newPartTypes;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "part_nickname")
    public String getPart_nickname() {
        return part_nickname;
    }

    public void setPart_nickname(String part_nickname) {
        this.part_nickname = part_nickname;
    }

    @XmlElementWrapper(name = "deep_subparts")
    @XmlElement(name = "subpart")
    public List<DeepSubpart> getDeep_subparts() {
        if (deep_subparts == null) {
            deep_subparts = new ArrayList<>();
        }
        return deep_subparts;
    }

    public void setDeep_subparts(List<DeepSubpart> deep_subparts) {
        this.deep_subparts = deep_subparts;
    }

    @XmlElementWrapper(name = "specified_subparts")
    @XmlElement(name = "subpart")
    public List<SpecifiedSubpart> getSpecified_subparts() {
        if (specified_subparts == null) {
            specified_subparts = new ArrayList<>();
        }
        return specified_subparts;
    }

    public void setSpecified_subparts(List<SpecifiedSubpart> specified_subparts) {
        this.specified_subparts = specified_subparts;
    }

    @XmlElementWrapper(name = "specified_subscars")
    @XmlElements({
        @XmlElement(name = "scar", type = Scar.class),
        @XmlElement(name = "subpart", type = SpecifiedSubscarSubpart.class)
    })
    public List<SpecifiedSubscar> getSpecified_subscars() {
        if (specified_subscars == null) {
            specified_subscars = new ArrayList<>();
        }
        return specified_subscars;
    }

    public void setSpecified_subscars(List<SpecifiedSubscar> specified_subscars) {
        this.specified_subscars = specified_subscars;
    }

    @XmlElementWrapper(name = "features")
    @XmlElement(name = "feature")
    public List<Feature> getFeatures() {
        if (features == null) {
            features = new ArrayList<>();
        }
        return features;
    }
    
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "category")
    public List<Category> getCategories() {
        if (categories == null) {
        	categories = new ArrayList<>();
        }
        return categories;
    }

    /*
     * @XmlElement(name = "deep_subparts") public Deep_subparts
     * getDeepSubparts() { return deepSubparts; }
     *
     * public void setDeepSubparts(Deep_subparts newSubpart) { this.deepSubparts
     * = newSubpart; }
     */
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElementWrapper(name = "sequences")
    @XmlElement(name = "seq_data")
    public List<String> getSeq_data() {
        return seq_data;
    }

    public void setSequence(List<String> newSequence) {
        this.seq_data = newSequence;
    }

    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\npart [\n"
                + (part_name != null ? "part_name: " + part_name + ", \n" : "")
                + (part_nickname != null ? "part_nickname: " + part_nickname + ", \n" : "")
                + (part_short_desc != null ? "part_short_desc: '" + part_short_desc + "', \n" : "")
                + (seq_data != null ? "dna_sequence: " + seq_data + "\n" : "")
                //+ (deepSubparts != null ? "deepSubparts: " + deepSubparts + "\n" : "")
                + (deep_subparts != null ? "deepSubparts: " + deep_subparts + "\n" : "")
                + (deep_subparts != null ? "subpart length: |" + deep_subparts.size() + "| \n" : "");

    }

    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData) {
        biobrick.setURI(URI.create("http://partsregistry.org/part/" + part_name)); //Need to make dynamic
        biobrick.setDisplayId(part_name);
        biobrick.setDescription(part_short_desc);
        biobrick.setName(part_nickname);

        if (part_types != null) {
            
            for (String aType : part_types) {
                aType = aType.toLowerCase();
                if (Vocabulary.SO_MAP.get(aType) != null) {
                    biobrick.addType(Vocabulary.SO_MAP.get(aType));
                }
                biobrick.addRegistry_type(PartsRegistrySBOLVocabulary.uri(aType));
            }
        }
        
        if ((seq_data != null) && !seq_data.isEmpty()) {

            DnaSequence sequenceObject = PartsRegistrySBOLFactory.createDnaSequence();

            for (String aSeq : seq_data) {
                if (!aSeq.isEmpty()) {
                    sequenceObject.setNucleotides(aSeq.replaceAll("\\s+", ""));
                    sequenceObject.setURI(URI.create("http://partsregistry.org/seq/partseq_" + part_id)); //Need to make dynamic
                    biobrick.setDnaSequence(sequenceObject);
                }
            }
        }

        /* Specified Subparts are always! duplicates of specified subscars - they only provide a non-scar view of Parts 
        if (specified_subparts != null) {
            SequenceAnnotation nextSA = null;
            List<SequenceAnnotation> revSAList = new ArrayList<>();
            for (int i = specified_subparts.size() - 1; i >= 0; i--) {
                SequenceAnnotation thisSA = specified_subparts.get(i).toSbol(biobrick, rsbpmlData, i, nextSA);
                revSAList.add(thisSA);
                nextSA = thisSA;
            }
            for (int i = revSAList.size() - 1; i >= 0; i--) {
                biobrick.addAnnotation(revSAList.get(i));
            }
        }
        */
        if (specified_subscars != null) {
            SequenceAnnotation nextSA = null;
            List<SequenceAnnotation> revSAList = new ArrayList<>();
            for (int i = specified_subscars.size() - 1; i >= 0; i--) {
                SequenceAnnotation thisSA = specified_subscars.get(i).toSbol(biobrick, rsbpmlData, i, nextSA);
                revSAList.add(thisSA);
                nextSA = thisSA;
            }
            for (int i = revSAList.size() - 1; i >= 0; i--) {
                biobrick.addAnnotation(revSAList.get(i));
            }
        }
        if (features != null) {
            int i = 0;
            for (Feature aSubpart : features) {
                i++;
                biobrick = aSubpart.toSbol(biobrick, rsbpmlData, i);
            }
        }
        
        /* Duplicate deep parts cause the specified subscar precedes relationships to be inconsistent 
         * because deep subparts include some specified subscar subparts. Duplicates need to be skipped 
         * and precedes need to be reconnected. 
         */ /*
        if (deep_subparts != null) {
        	SequenceAnnotation nextSA = null;
            List<SequenceAnnotation> revSAList = new ArrayList<>();
            for (int i = deep_subparts.size() - 1; i >= 0; i--) {
            	SequenceAnnotation thisSA = deep_subparts.get(i).toSbol(biobrick, rsbpmlData, i, nextSA);
            	for (SequenceAnnotation subpartSA: biobrick.getAnnotations()){
            		if (thisSA.getSubComponent().getURI().equals(subpartSA.getSubComponent().getURI())){
            			//there is atleat one deep subpart that matches an already existing annotation
            		}
            	}
                revSAList.add(thisSA);
                nextSA = thisSA;
            }
            for (int i = revSAList.size() - 1; i >= 0; i--) {
            	biobrick.addAnnotation(revSAList.get(i));
            }
        }
        */
        if (categories != null) {
            int i = 0;
            
            for (Category aCategory : categories) {
                i++;
                biobrick = aCategory.toSbol(biobrick, rsbpmlData, i);
            }
        }        
        
        return biobrick;
    }
}
