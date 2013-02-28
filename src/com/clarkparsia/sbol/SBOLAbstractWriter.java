/*
 * Copyright (c) 2012 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clarkparsia.sbol;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.GregorianCalendar;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.rio.RDFHandlerException;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLVisitor;
import org.sbols.converter.sbol.PartsRegistrySBOLVocabulary;
import org.sbolstandard.core.*;
import org.sbolstandard.core.impl.SBOLValidatorImpl;
import org.sbolstandard.core.util.SBOLBaseVisitor;


/**
 * Utility class that provides a skeletal implementation of the {@link SBOLWriter} interface to minimize the effort
 * required to implement this interface using a SBOLVisitor.
 * 
 * @author Evren Sirin
 */
public abstract class SBOLAbstractWriter implements SBOLWriter {
	private final boolean validate;

	public SBOLAbstractWriter(boolean validate) {
		this.validate = validate;
	}

    public boolean isValidate() {
        return validate;
    }

    /**
	 * {@inheritDoc}
	 */
	@Override
	public void write(SBOLDocument doc, OutputStream out) throws IOException {
		if (validate) {
			new SBOLValidatorImpl().validateWithoutSchema(doc);
		}
        try {
            doc.accept(createWriter(out));
        } catch (RDFHandlerException e) {
            throw new IOException("Unable to write document", e);
        }
    }

	/**
	 * Additional utility function to write only the contents of a given object rather than th whole document.
	 */
	public void write(SBOLVisitable obj, OutputStream out) throws RDFHandlerException {
		obj.accept(createWriter(out));
	}

	public String write(SBOLVisitable obj) throws RDFHandlerException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		write(obj, out);
		return new String(out.toByteArray());
	}

	protected abstract SBOLVisitor<RDFHandlerException> createWriter(OutputStream out);
	
	/**
	 * An abstract visitor implementation for writing SBO objects that handles the navigation of the SBOL object model and
	 * leaves out only the serialization of attribute values to its concrete subclasses.
	 * 
	 * @author Evren Sirin
	 */
	
    protected static abstract class SBOLAbstractWriterVisitor
            extends SBOLBaseVisitor<RDFHandlerException>
            implements PartsRegistrySBOLVisitor<RDFHandlerException>
    {
		protected static ValueFactory FACTORY = ValueFactoryImpl.getInstance();
		protected static URI DUMMY = FACTORY.createURI("urn:dummy");
		
		protected final Deque<Resource> subjList;
		protected final Deque<URI> propList;
		protected Resource subj;
		protected URI prop;

		public SBOLAbstractWriterVisitor() {
			subjList = new ArrayDeque<Resource>();
			propList = new ArrayDeque<URI>();
			subj = DUMMY;
			prop = DUMMY;
		}

        @Override
        public void visit(Collection coll) throws RDFHandlerException {
            startSubj(coll, SBOLVocabulary.Collection);
            writeProp(SBOLVocabulary.displayId, coll.getDisplayId());
            writeProp(SBOLVocabulary.description, coll.getDescription());
            super.visit(coll);
            endSubj();
        }

        @Override
        public void visit(PartsRegistryDnaComponent component) throws RDFHandlerException {
            startSubj(component, SBOLVocabulary.DnaComponent);
            writeProp(RDF.TYPE, component.getTypes());
            writeProp(SBOLVocabulary.displayId, component.getDisplayId());
            writeProp(SBOLVocabulary.name, component.getName());
            writeProp(SBOLVocabulary.description, component.getDescription());
            if (component.getDnaSequence() != null) {
                startProp(SBOLVocabulary.dnaSequence);
                visit(component.getDnaSequence());
                endProp();
            }
            java.util.Collection<SequenceAnnotation> annotations = component.getAnnotations();
            if (!annotations.isEmpty()) {
                startProp(SBOLVocabulary.annotation);
                for (SequenceAnnotation sequenceAnnotation : annotations) {
                    visit(sequenceAnnotation);
                }
                endProp();
            }
            writeProp(RDF.TYPE, component.getRegistry_types());
            writeProp(PartsRegistrySBOLVocabulary.status, component.getStatus());
            endSubj();
        }

        @Override
        public void visit(DnaSequence sequence) throws RDFHandlerException {
            if (sequence != null) {
                startSubj(sequence, SBOLVocabulary.DnaSequence);
                writeProp(SBOLVocabulary.nucleotides, sequence.getNucleotides());
                endSubj();
            }
		}

		@Override
        public void visit(SequenceAnnotation annotation) throws RDFHandlerException {
            startSubj(annotation, SBOLVocabulary.SequenceAnnotation);
            writeProp(SBOLVocabulary.precedes, annotation.getPrecedes());
            writeProp(SBOLVocabulary.bioStart, annotation.getBioStart());
            writeProp(SBOLVocabulary.bioEnd, annotation.getBioEnd());
            writeProp(SBOLVocabulary.strand, annotation.getStrand());
            PartsRegistryDnaComponent subComponent = (PartsRegistryDnaComponent) annotation.getSubComponent();
            if (subComponent != null) {
                startProp(SBOLVocabulary.subComponent);
                visit(subComponent);
                endProp();
            }
            endSubj();
		}
		
		protected void startSubj(SBOLObject obj, URI type) throws RDFHandlerException {
			URI newSubj = FACTORY.createURI(obj.getURI().toString());
			if (prop != DUMMY) {
				write(subj, prop, newSubj);
			}
			subjList.push(subj);
			subj = newSubj;
			write(subj, RDF.TYPE, type);
		}

		protected void endSubj() {			
			subj = subjList.pop();
		}
		  
		protected void startProp(URI property) {
			propList.push(prop);
			prop = property;
		}

		protected void endProp() {
			prop = propList.pop();
		}

		protected void writeProp(URI prop, Object value) throws RDFHandlerException {
			if (value != null) {
				if (value instanceof java.util.Collection) {
					@SuppressWarnings("rawtypes")
		            java.util.Collection values = (java.util.Collection) value; 
					for (Object v : values) {
						writeProp(prop, v);
					}
				}
				else {
					Value obj;
					if (value instanceof SBOLObject) {
						obj = FACTORY.createURI(((SBOLObject) value).getURI().toString());
					}
					else if (value instanceof java.net.URI) {
						obj = FACTORY.createURI(value.toString());
					}
					else if (value instanceof Date) {
						GregorianCalendar cal = new GregorianCalendar();
						cal.setTime((Date) value);
						obj = FACTORY.createLiteral(new XMLGregorianCalendarImpl(cal));
					}
					else {
						obj = FACTORY.createLiteral(value.toString());
					}
					write(subj, prop, obj);
				}
			}
		}
		  
		protected abstract void write(Resource subj, URI pred, Value obj) throws RDFHandlerException ;
	}
}
