package com.orion.zd.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion.zd.domain.SoldListing;
import com.orion.zd.persistence.SoldListingMapper;

@Service
public class SoldListingService {

	@Autowired
	private SoldListingMapper mapper;
	
	public void addListing(SoldListing listing){
		mapper.addListing(listing);
	}
	public void addListing(Hashtable<String,Object> listingTable){
		SoldListing listing = new SoldListing();
		listing.setMls((Integer)listingTable.get("mls"));
		listing.setBac((String)listingTable.get("bac"));
		listing.setType((String)listingTable.get("type"));	
		listing.setSellerOffice((String)listingTable.get("sellerOffice"));
		listing.setAddress((String)listingTable.get("address"));
		listing.setListingOffice((String)listingTable.get("listingOffice"));
		listing.setSoldDate((Date)listingTable.get("soldDate"));
		listing.setBed((Integer)listingTable.get("bed"));	
		listing.setBath((Integer)listingTable.get("bath"));
		listing.setYear((Integer)listingTable.get("year"));
		listing.setListDate((Date)listingTable.get("listDate"));
		listing.setLongitude((Double)listingTable.get("longitude"));
		listing.setLatitude((Double)listingTable.get("latitude"));
		listing.setAcres((Float)listingTable.get("acres"));
		listing.setImage((String)listingTable.get("image"));
		listing.setListPrice((Integer)listingTable.get("listPrice"));
		listing.setCity((String)listingTable.get("city"));
		listing.setStyle((String)listingTable.get("style"));
		listing.setListingAgent((String)listingTable.get("listingAgent"));
		listing.setZip((Integer)listingTable.get("zip"));
		listing.setBrokerage((String)listingTable.get("brokerage"));
		listing.setSqft((Integer)listingTable.get("sqft"));
		listing.setSoldPrice((Integer)listingTable.get("soldPrice"));
		listing.setSellerAgent((String)listingTable.get("sellerAgent"));
		listing.setGarage((Integer)listingTable.get("garage"));
		mapper.addListing(listing);
	}
	public SoldListing getListing(int mls){
		return mapper.getListing(mls);
	}
	public List<SoldListing> getAllListing(int zip,String type,String style,int soldYear){
		Date firstDate = new Date(soldYear-1900-3, 1, 1);
		Date lastDate = new Date(soldYear-1900+1, 12, 31);
		return mapper.getAllListing(type,style,zip,firstDate,lastDate);
	}
}
