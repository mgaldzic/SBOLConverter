/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.sbol;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.sbolstandard.core.SBOLVisitor;
import org.sbolstandard.core.impl.DnaComponentImpl;

/**
 *
 * @author mgaldzic
 */
public class PartsRegistryDnaComponent extends DnaComponentImpl {
    protected final List<URI> registry_types = new ArrayList<URI>();

    public PartsRegistryDnaComponent() {
    }

    @Override
    public <T extends Throwable> void accept(SBOLVisitor<T> visitor) throws T {
        if (visitor instanceof PartsRegistrySBOLVisitor) {
            ((PartsRegistrySBOLVisitor<T>) visitor).visit(this);
        } else {
            visitor.visit(this);
        }
    }
        public List<URI> getRegistry_types() {
		return this.registry_types;
	}

	public void addRegistry_types(URI registry_type) {
    	getRegistry_types().add(registry_type);
    }
}