package org.sbols.converter.rsbpml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.sbols.converter.sbol.PartsRegistryDnaComponent;
import org.sbols.converter.sbol.PartsRegistrySBOLVocabulary;


@XmlRootElement(name = "category")
public class Category {

	private String category;

	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlValue
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "\ncategory ["
				+ (category != null ? category + "] \n" : "");
	}
	private String parse_category(){
		String t = category.toLowerCase();
		t = t.replaceAll("^ +", ""); // leading spaces
		//t = t.replaceAll("\\N", "");
		t = t.replaceAll("^//", ""); //leading '//' do not delim
        t = t.replaceAll("/","_");
        t = t.replaceAll("\\s+", "");
        t = t.replaceAll("\\t+", "");
        t = t.replaceAll("\\cM", ""); // \015 #any ctrl-M
        t = t.replaceAll("]", "");
        t = t.replaceAll("\\[", "");

        List<String> list = Arrays.asList(t.split("_"));
        Collections.reverse(list);
        Iterator<String> it = list.iterator();
        final StringBuilder type = new StringBuilder(it.next());
        while (it.hasNext()) { 
        	type.append("_");
        	type.append(it.next()); 
        }
        
		return type.toString();
	}

	public PartsRegistryDnaComponent toSbol(PartsRegistryDnaComponent biobrick,	Rsbpml rsbpmlData, int position) {
		String aType = parse_category();
        if (Vocabulary.SO_MAP.get(aType) != null) {
            biobrick.addType(Vocabulary.SO_MAP.get(aType));
        }
        biobrick.addRegistry_type(PartsRegistrySBOLVocabulary.uri(aType));
		return biobrick;
	}

	/*
    78 def map_to_part(row,part):
    79     p=part
    80     cat_list = parse_categories(row['categories']) 
   121 
   122     p.subClassOf = parse_catlist(cat_list)
   129     return p
   
   131 def parse_catlist(cat_list):
   132     classes = {}
   133     for cat in cat_list:
   134         catterms = cat.split('_')
   135         superclass = str(catterms[0])
   136         catterms.reverse()
   137         directparent = "_".join(catterms)
   138         classes[directparent]=superclass
   139     #for directparent,superclass in classes.iteritems():
   140     #    print 'dirp: ' + str(directparent)
   141     #    print 'superclass: ' +str(superclass)
   142     return classes

	 */
}
