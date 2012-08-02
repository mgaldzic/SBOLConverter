package org.sbols.converter.rsbpml;

import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbolstandard.core.DnaSequence;
import org.sbolstandard.core.SBOLFactory;

public class dnaSequenceData {
	
	private DnaSequence sequenceObject = SBOLFactory.createDnaSequence();
	private String nucleotides;
	
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name="seq_data")
	public String getNucleotides(){
		return nucleotides;
	}
	
	public void setNucleotides(String sequenceData){
		this.nucleotides = sequenceData;
	}
	
	@Override
	public String toString(){
		 return (nucleotides != null ? "Nucleotides: " + nucleotides : "") +  "]";
	}
	
	public DnaSequence toSbol(){
		sequenceObject.setNucleotides(nucleotides);
		sequenceObject.setURI(URI.create("http://example.com/MyDnaComponentSequence")); //Need to make dynamic
		return sequenceObject;
	}
}
