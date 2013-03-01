/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbols.converter.sbol;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.sbolstandard.core.SBOLVisitor;
import org.sbolstandard.core.impl.DnaComponentImpl;

/**
 *
 * @author mgaldzic
 */
public class PartsRegistryDnaComponent extends DnaComponentImpl {
    protected final List<URI> registry_types = new ArrayList<URI>();
    protected String status;
	protected String creator;
	private Date date;

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

	public void addRegistry_type(URI registry_type) {
    	getRegistry_types().add(registry_type);
    }
	
    public String getStatus() {
    	return this.status;
    }

    public void setStatus(String status) {
    	this.status = status;
    }
    
    public String getCreator(){
    	return this.creator;
    }
    
    public void setCreator(String creator) {
    	this.creator = creator;
    }
    
    public Date getDate(){
    	return this.date;
    }
    
    public void setDate(Date date) {
    	this.date = date;
    }
}