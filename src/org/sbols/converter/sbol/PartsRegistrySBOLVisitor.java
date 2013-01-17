package org.sbols.converter.sbol;

import org.sbolstandard.core.SBOLVisitor;

/**
 * Extended SBOL visitor interface to support visiting Registry specific SBOL extensions. 
 * 
 * @author mgaldzic
 */
public interface PartsRegistrySBOLVisitor<T extends Throwable> extends SBOLVisitor<T> {
	public void visit(PartsRegistryDnaComponent component) throws T;

}
