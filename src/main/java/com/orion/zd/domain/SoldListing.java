package com.orion.zd.domain;

import java.util.Date;

public class SoldListing {
	
	private int id;
	private int mls;
	private double latitude;
	private double longitude;
	private Date listDate;
	private int listPrice;
	private Date soldDate;
	private int soldPrice;
	private String type;
	private String style;
	private int year;
	private float acres;
	private int bed;
	private int bath;
	private int sqft;
	private int garage;
	private String address;
	private String city;
	private int zip;
	private String listingAgent;
	private String listingOffice;
	private String bac;
	private String brokerage;
	private String image;
	private String sellerAgent;
	private String sellerOffice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMls() {
		return mls;
	}
	public void setMls(int mls) {
		this.mls = mls;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getListDate() {
		return listDate;
	}
	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getAcres() {
		return acres;
	}
	public void setAcres(float acres) {
		this.acres = acres;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public int getBath() {
		return bath;
	}
	public void setBath(int bath) {
		this.bath = bath;
	}
	public int getSqft() {
		return sqft;
	}
	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	public int getGarage() {
		return garage;
	}
	public void setGarage(int garage) {
		this.garage = garage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getListingAgent() {
		return listingAgent;
	}
	public void setListingAgent(String listingAgent) {
		this.listingAgent = listingAgent;
	}
	public String getBac() {
		return bac;
	}
	public void setBac(String bac) {
		this.bac = bac;
	}
	public String getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(String brokerage) {
		this.brokerage = brokerage;
	}
	public String getListingOffice() {
		return listingOffice;
	}
	public void setListingOffice(String listingOffice) {
		this.listingOffice = listingOffice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerAgent() {
		return sellerAgent;
	}
	public void setSellerAgent(String sellerAgent) {
		this.sellerAgent = sellerAgent;
	}
	public String getSellerOffice() {
		return sellerOffice;
	}
	public void setSellerOffice(String sellerOffice) {
		this.sellerOffice = sellerOffice;
	}
	
}
