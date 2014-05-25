package com.orion.zd.domain;

import java.io.Serializable;

public class Street implements Serializable{
	
	private static final long serialVersionUID = 8751282105538759742L;
	
	private int id;
	private int zip;
	private String name;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString(){
		return "id : "+id+" name : "+name+" type : "+type+" zip : "+zip;
	}
}
