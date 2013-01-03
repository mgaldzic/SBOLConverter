package org.sbols.converter.sbol;

import org.sbolstandard.core.SBOLVisitor;

/**
 * Extended SBOL visitor interface to support visiting Registry specific SBOL extensions. 
 * 
 * @author mgaldzic
 */
public interface PartsRegistrySBOLVisitor extends SBOLVisitor {
	public void visit(PartsRegistryDnaComponent component);

}
