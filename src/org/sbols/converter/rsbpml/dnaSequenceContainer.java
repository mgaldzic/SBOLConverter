/*
 * Defines DNA Sequence information contained in <dnaSequence>
 */
package org.sbols.converter.rsbpml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.sbolstandard.core.DnaComponent;

@XmlRootElement(name = "dnaSequence")
public class dnaSequenceContainer {

    private dnaSequenceData dna_sequence;

    @XmlElement(name = "DnaSequence")
    public dnaSequenceData getSequence() {
        return dna_sequence;
    }

    public void setSequence(dnaSequenceData newSequence) {
        this.dna_sequence = newSequence;
    }

    @Override
    public String toString() {
        return "dnaSequence [" + (dna_sequence != null ? "DnaSequence: " + dna_sequence : "") + "]";
    }

    public DnaComponent toSbol(DnaComponent biobrick) {
        biobrick.setDnaSequence(dna_sequence.toSbol());
        return biobrick;
    }
}
