package com.orion.zd.script;

import java.util.ArrayList;
import java.util.Hashtable;

import com.orion.zd.scraper.component.Scraper;
import com.orion.zd.scraper.component.ScraperUrl;
import com.orion.zd.scraper.component.SimpleScraper;
import com.orion.zd.scraper.decorator.AuthSoldWFRMLS;
import com.orion.zd.scraper.impl.SoldListingScraperImpl;
import com.orion.zd.service.SoldListingService;

public class AllSoldListing {
	
	public static int[] randomTable = null;
	public static int index = 0;
	public static int max = 2633;
	public static boolean work = true;
	
	private SoldListingService soldListingService;
	
	public AllSoldListing(SoldListingService soldListingService){
		this.soldListingService = soldListingService;
		creationRandomTable();
	}
	private void creationRandomTable(){
		randomTable = new int[max];
		for(int i=0;i<max;i++){
			randomTable[i] = i+1;
		}
		for(int i=0;i<100000;i++){
			int random1 = 0 + (int)(Math.random() * ((max-1 - 0) + 0));
			int random2 = 0 + (int)(Math.random() * ((max-1 - 0) + 0));
			int temp = randomTable[random1];
			randomTable[random1] = randomTable[random2];
			randomTable[random2] = temp;
		}
	}
	public void job(){
		if(work){
			Scraper soldListingsScraper = new SimpleScraper(new ScraperUrl("http://www.utahrealestate.com/search/perform?page="+randomTable[index]),"soldListings.xml");
			index++;
			soldListingsScraper = new AuthSoldWFRMLS(soldListingsScraper);
			soldListingsScraper.scrap(); 
			ArrayList<Hashtable<String,String>> allMlsListings = soldListingsScraper.getScrappedData();
			SoldListingScraperImpl soldListingScraper = new SoldListingScraperImpl();
			int count = 200;
			for(Hashtable<String,String> mlsListing : allMlsListings){
				int mls = Integer.parseInt(mlsListing.get("mls"));
				
				if(soldListingService.getListing(mls) == null){
					soldListingService.addListing(soldListingScraper.getData(mls));
				}else{
					count--;
				}
			}
			//System.out.println(randomTable[index]);
		}
	}
}
