package com.orion.zd.scraper.component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ScraperObject {
	
	private Class objClass;
	private List<ScraperAttribute> attributes;
	
	public ScraperObject(Class objClass){
		this.objClass = objClass;
		this.attributes = new ArrayList<ScraperAttribute>();
	}
	
	public void addAttribute(ScraperAttribute newAttribute){
		if(this.attributeBelongs(newAttribute.getName())){
			this.attributes.add(newAttribute);
		}else{
			System.out.println("ERROR : "+newAttribute.getName()+" don't belong to "+this.objClass);
		}
	}
	
	private boolean attributeBelongs(String attributeName){
		for(Field field : this.objClass.getDeclaredFields()){
			if(field.getName().equals(attributeName)){
				return true;
			}
		}
		return false;
	}
}
