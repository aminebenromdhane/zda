package com.orion.zd.scraper.impl;

import java.util.Hashtable;

import com.orion.zd.data.filter.SoldListingFilter;
import com.orion.zd.scraper.component.Scraper;
import com.orion.zd.scraper.component.ScraperUrl;
import com.orion.zd.scraper.component.SimpleScraper;
import com.orion.zd.scraper.decorator.AuthSoldWFRMLS;

public class SoldListingScraperImpl {

	private Scraper soldListingScraper;
	
	public SoldListingScraperImpl(){
		soldListingScraper = new SimpleScraper("soldListing.xml");
		soldListingScraper = new AuthSoldWFRMLS(soldListingScraper);
	}
	
	public Hashtable<String, Object> getData(int mls){
		soldListingScraper.setUrlToScrap(new ScraperUrl("http://www.utahrealestate.com/report/display/report/full/type/1/in_pop/1/listno/"+mls+"/force//actor/"));
		soldListingScraper.scrap();
		Hashtable<String, String> data = soldListingScraper.getScrappedData().get(0);
		soldListingScraper.emptyData();
		Hashtable<String, Object> filtredData = filterData(data);
		return filtredData;
	}
	private Hashtable<String, Object> filterData(Hashtable<String, String> data){
		Hashtable<String, Object> filtredData = new Hashtable<String, Object>();
		filtredData.put("mls", SoldListingFilter.mls(data.get("mls")));
		filtredData.put("image", SoldListingFilter.image(data.get("image")));
		filtredData.put("listPrice",SoldListingFilter.listPrice(data.get("listPrice")));
		filtredData.put("listDate",SoldListingFilter.listDate(data.get("listDate")));
		filtredData.put("soldPrice",SoldListingFilter.soldPrice(data.get("soldPrice")));
		filtredData.put("soldDate",SoldListingFilter.soldDate(data.get("soldDate")));
		filtredData.put("address",SoldListingFilter.address(data.get("address")));
		filtredData.put("latitude",SoldListingFilter.latitude(data.get("latitude")));
		filtredData.put("longitude",SoldListingFilter.longitude(data.get("longitude")));
		filtredData.put("city",SoldListingFilter.city(data.get("city")));
		filtredData.put("zip",SoldListingFilter.zip(data.get("zip")));
		filtredData.put("type",SoldListingFilter.type(data.get("type")));
		filtredData.put("style",SoldListingFilter.style(data.get("style")));
		filtredData.put("year",SoldListingFilter.year(data.get("year")));
		filtredData.put("acres",SoldListingFilter.acres(data.get("acres")));
		filtredData.put("garage",SoldListingFilter.garage(data.get("garage")));
		filtredData.put("sqft",SoldListingFilter.sqft(data.get("sqft")));
		filtredData.put("bath",SoldListingFilter.bath(data.get("bath1"),data.get("bath2"),data.get("bath3")));
		filtredData.put("acres",SoldListingFilter.acres(data.get("acres")));
		filtredData.put("bed",SoldListingFilter.bed(data.get("bed")));
		filtredData.put("listingAgent",SoldListingFilter.listingAgent(data.get("listingAgent")));
		filtredData.put("listingOffice",SoldListingFilter.listingOffice(data.get("listingOffice")));
		filtredData.put("brokerage",SoldListingFilter.brokerage(data.get("brokerage")));
		filtredData.put("sellerAgent",SoldListingFilter.sellerAgent(data.get("sellerAgent")));
		filtredData.put("sellerOffice",SoldListingFilter.sellerOffice(data.get("sellerOffice")));
		filtredData.put("bac",SoldListingFilter.bac(data.get("bac")));
		return filtredData;
	}
}
