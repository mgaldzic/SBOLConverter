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
import org.sbolstandard.core.impl.SBOLValidatorImpl;

@XmlRootElement(name = "feature")
public class Feature {

	private String id;
	private String title;
	// private String type;
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

	private PartsRegistryDnaComponent assignType(
			PartsRegistryDnaComponent feature) {
		if (types != null) {

			for (String aType : types) {
				aType = aType.toLowerCase();
				if (Vocabulary.SO_MAP.get(aType) != null) {
					feature.addType(Vocabulary.SO_MAP.get(aType));
				}
				feature.addRegistry_type(PartsRegistrySBOLVocabulary.uri(aType));
			}
		}
		return feature;
	}

	private PartsRegistryDnaComponent assignPartFeature(PartsRegistryDnaComponent biobrick) {
		SequenceAnnotation newFeatureSA = PartsRegistrySBOLFactory.createSequenceAnnotation();
		URI featureuri = URI.create("http://partsregistry.org/part/" + title);

		if (biobrick.getAnnotations().size() > 0) { // Actual annotations already exist
			boolean isAlreadySubPart = false;
			for (SequenceAnnotation subpartSA : biobrick.getAnnotations()) { // for any of them
				if (!featureuri.equals(subpartSA.getSubComponent().getURI())) { // NOT Already a *Subpart
					isAlreadySubPart = false;

					PartsRegistryDnaComponent newDCFeature = PartsRegistrySBOLFactory.createDnaComponent();
					newDCFeature.setURI(featureuri);
					newDCFeature.setDisplayId(title);
					newDCFeature = assignType(newDCFeature);
					newFeatureSA.setSubComponent(newDCFeature);
					newFeatureSA = assignAnnotation(newFeatureSA);

				} else { // Already a *SubPart
					isAlreadySubPart = true;
					// SA gets new position
					// TODO likely Features in reverse will incorrectly be assigned as fwd
					subpartSA.setBioStart(Integer.parseInt(startpos));
					subpartSA.setBioEnd(Integer.parseInt(endpos));
					// if direction fwd then
					// subpartSA.setStrand(StrandType.POSITIVE); 
					//if rev then NEGATIVE (What if conflict?)
					subpartSA.setStrand(StrandType.POSITIVE); // this is a hack
																// (ultimately it
																// should be
																// done by
																// checking)

					for (String aType : types) {  //Doing it this way allows us to add a SO and non SO type to a non PR DC.. 
						aType = aType.toLowerCase();
						if (Vocabulary.SO_MAP.get(aType) != null) {
							subpartSA.getSubComponent().addType(Vocabulary.SO_MAP.get(aType));
						}
						subpartSA.getSubComponent().getTypes().add(PartsRegistrySBOLVocabulary.uri(aType));
					}
				}
			}
			if (!isAlreadySubPart) biobrick.addAnnotation(newFeatureSA);
		} else { // Only features, these features are not Parts, no parts exist: create a new one

			PartsRegistryDnaComponent newDCFeature = PartsRegistrySBOLFactory.createDnaComponent();
			newFeatureSA = assignAnnotation(newFeatureSA);
			newDCFeature.setURI(featureuri);
			newDCFeature.setDisplayId(title);
			newDCFeature = assignType(newDCFeature);
			newFeatureSA.setSubComponent(newDCFeature);
			biobrick.addAnnotation(newFeatureSA);
		}
		return biobrick;
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

	private SequenceAnnotation assignAnnotation(SequenceAnnotation newAnnotation) {
		newAnnotation.setURI(URI.create("http://partsregistry.org/anot/f_" + id));

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
	
	private boolean isAnnotationValid(SequenceAnnotation anot){
		boolean isValid = true;
		System.out.println("a "+anot.getSubComponent().getDisplayId());
		Integer expectedLength = anot.getBioEnd() - anot.getBioStart() + 1;
		if (!(expectedLength > 0)) { 
			isValid = false;
			//throw new SBOLValidationException("Inconsistent startpos and endpos rsbpml.Feature values"); 
		} 
		if (Integer.parseInt(startpos) < 1) {
			isValid = false;
			//throw new SBOLValidationException("startpos < 0 rsbpml.Feature values"); 
		}
		return isValid;
	}

	@Override
	// need to edit this later to reflect changes
	public String toString() {
		return "\nfeature [\n"
				+ (title != null ? "title: " + title + ", \n" : "")
				+ (types != null ? "types: " + types + ", \n" : "")
				+ (direction != null ? "direction: " + direction + ", \n" : "");
	}

	public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick,	Rsbpml rsbpmlData, int position) {
		SequenceAnnotation newFeatureSA = SBOLFactory.createSequenceAnnotation();

		if (title != null && title.startsWith("BBa_") && title.split("\\s+").length == 1) {
			biobrick = assignPartFeature(biobrick); // either a new featureSA is created or biobrick is updated

		} else {
			PartsRegistryDnaComponent featDC = assignNotPartFeature(); // a new featureDC is created
			newFeatureSA.setSubComponent(featDC);
			newFeatureSA = assignAnnotation(newFeatureSA);
			//System.out.println("f: "+newFeatureSA);
			biobrick.addAnnotation(newFeatureSA);
			
		}
		
		//throw away the feature if its invalid, the rest of  the DC may be good
		if (newFeatureSA.getURI() != null && !isAnnotationValid(newFeatureSA)){
			biobrick.removeAnnotation(newFeatureSA);
		}

		return biobrick;
	}
}
