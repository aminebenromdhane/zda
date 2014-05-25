package com.orion.zd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion.zd.script.AllSoldListing;
import com.orion.zd.service.SoldListingService;

@RestController
public class SoldDataController {
	
	@Autowired
	private SoldListingService soldListingService;
	
	@RequestMapping(value = "sold/scrap")
	public void scrap() {
		AllSoldListing soldListingScraper = new AllSoldListing(soldListingService);
		while(AllSoldListing.index < AllSoldListing.max){
			soldListingScraper.job();
		}
	}
	
	@RequestMapping(value = "sold/stop")
	public void stop() {
		AllSoldListing.work = false;
	}
	
	@RequestMapping(value = "sold/start")
	public void start() {
		AllSoldListing.work = true;
	}
	
	@RequestMapping(value = "sold/stat")
	public String stat() {
		return String.valueOf(AllSoldListing.work);
	}
	
	@RequestMapping(value = "sold/isrun")
	public String isrun() {
		return String.valueOf(AllSoldListing.index != 0);
	}
	
	@RequestMapping(value = "sold/remain")
	public String remain() {
		return (AllSoldListing.index+"/"+AllSoldListing.max);
	}
}
