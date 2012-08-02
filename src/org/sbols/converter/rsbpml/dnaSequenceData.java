package org.sbols.converter.rsbpml;

import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sbolstandard.core.DnaSequence;

public class dnaSequenceData {
	
	private DnaSequence sequenceObject;
	private String seq_data;
	
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name="seq_data")
	public String getNuleotides(){
		return seq_data;
	}
	
	public void setNucleotides(String seq_data){
		this.seq_data = seq_data;
	}
	
	public DnaSequence toSbol(){
		sequenceObject.setURI(URI.create("http://example.com/MyDnaComponentSequence")); //Need to make dynamic
		sequenceObject.setNucleotides(seq_data);
		return sequenceObject;
	}
}
