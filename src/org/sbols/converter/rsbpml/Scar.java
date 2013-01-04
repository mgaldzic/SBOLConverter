package org.sbols.converter.rsbpml;

import java.net.URI;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLFactory;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.DnaSequence;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SequenceAnnotation;

@XmlRootElement(name = "scar")
public class Scar extends SubThing{

    private String scar_id;
    private String scar_standard;
    private String scar_type;
    private String scar_name;
    private String scar_nickname;
    //scar_comments
    private String scar_sequence;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_id")
    public String getScar_id() {
        return scar_id;
    }

    public void setScar_id(String scar_id) {
        this.scar_id = scar_id;
    }
    
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_standard")
    public String getScar_standard() {
        return scar_standard;
    }

    public void setScar_standard(String scar_standard) {
        this.scar_standard = scar_standard;
    }
    
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_type")
    public String getScar_type() {
        return scar_type;
    }

    public void setScar_type(String scar_type) {
        this.scar_type = scar_type;
    }
    
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_name")
    public String getScar_name() {
        return scar_name;
    }

    public void setScar_name(String scar_name) {
        this.scar_name = scar_name;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_nickname")
    public String getScar_nickname() {
        return scar_nickname;
    }

    public void setScar_nickname(String scar_nickname) {
        this.scar_nickname = scar_nickname;
    }

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name = "scar_sequence")
    public String getScar_sequence() {
        return scar_sequence;
    }

    public void setScar_sequence(String scar_sequence) {
        this.scar_sequence = scar_sequence;
    }

    @Override //need to edit this later to reflect changes
    public String toString() {
        return "\nsubscar [\n"
                + (scar_name != null ? "scar_name: " + scar_name + ", \n" : "")
                + (scar_sequence != null ? "scar_sequence: " + scar_sequence + ", \n" : "")
                + (scar_nickname != null ? "scar_nickname: " + scar_nickname + ", \n" : "")                ;
    }
    
    protected SequenceAnnotation getNewSA (Rsbpml rsbpmlData, int index){
        DnaSequence scarSequence = SBOLFactory.createDnaSequence();
        scarSequence.setURI(URI.create("http://partsregistry.org/seq/scarseq_" + scar_id)); //TODO ?
        scarSequence.setNucleotides(scar_sequence);
        PartsRegistryDnaComponent SubDnaComponent = PartsRegistrySBOLFactory.createDnaComponent();
        SubDnaComponent.setURI(URI.create("http://partsregistry.org/part/RFC_" + scar_standard)); //TODO Need to make dynamic
        SubDnaComponent.setDisplayId(scar_name);
        SubDnaComponent.setName(scar_nickname);
        SubDnaComponent.setDnaSequence(scarSequence);
        SequenceAnnotation newAnnotation = SBOLFactory.createSequenceAnnotation();
        newAnnotation.setSubComponent(SubDnaComponent);
        
        int position = index+1;
        String parent_id = rsbpmlData.getPart_list().getPart().getPart_id();
        newAnnotation.setURI(URI.create("http://partsregistry.org/anot/sc_"+parent_id+"_"+scar_id+"_"+position));
        System.out.println("sp_pos "+position);
        return newAnnotation;
    }
    
    @Override
    public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick, Rsbpml rsbpmlData, int index) {
        SequenceAnnotation newAnnotation = getNewSA(rsbpmlData, index);
        
        System.out.println("BEGIN" + index);
        System.out.println("SAc " + newAnnotation.getURI());
        //Get next SA for SA.precedes, if it exists
        List<SubThing> mySubscars = rsbpmlData.getPart_list().getPart().getSpecified_subscars();
        System.out.println("my size :"+mySubscars.size()+" in+1 :"+(index+1));
        if (mySubscars.size() > (index + 1) && mySubscars.get(index + 1) != null) {
            //Capture next SA
            System.out.println("ms "+mySubscars.get(index+1));
                    //+mySubscars.get(index+1).toSbol(PartsRegistrySBOLFactory.createDnaComponent(), rsbpmlData, index).toString());
            SequenceAnnotation pSA 
                    //For the next subpart
                    = mySubscars.get(index+1) 
                    //get that ones, index+1's, SBOL
                    .toSbol(PartsRegistrySBOLFactory.createDnaComponent(), rsbpmlData, index+1) 
                    //get the SA out of it
                    .getAnnotations().get(index);
            //Make the .precedes connection
            System.out.println("pSA " + pSA.getURI());
            newAnnotation.addPrecede(pSA);
        }
        System.out.println("END" + index);
        
        biobrick.addAnnotation(newAnnotation);
        return biobrick;
    }
}
