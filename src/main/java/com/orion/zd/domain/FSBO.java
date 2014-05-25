package com.orion.zd.domain;

import java.io.Serializable;

public class FSBO implements Serializable{
	
	private static final long serialVersionUID = 8751282108712159742L;
	private int id;
	private long parcel;
	private String owner;
	private String address;
	private double acres;
	private int sqft;
	private String image;
	private int marketValue;
	
	public int getId() {
		return id;
	}
	
	public long getParcel() {
		return parcel;
	}
	public void setParcel(long parcel) {
		this.parcel = parcel;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAcres() {
		return acres;
	}
	public void setAcres(double acres) {
		this.acres = acres;
	}
	public int getSqft() {
		return sqft;
	}
	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}
	
	public String toString(){
		return "id : "+this.id;
	}
}
