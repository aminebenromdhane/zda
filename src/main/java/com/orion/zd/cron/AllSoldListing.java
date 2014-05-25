package com.orion.zd.cron;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.orion.zd.domain.SoldListing;
import com.orion.zd.scraper.component.Scraper;
import com.orion.zd.scraper.component.ScraperUrl;
import com.orion.zd.scraper.component.SimpleScraper;
import com.orion.zd.scraper.decorator.AuthSoldWFRMLS;
import com.orion.zd.scraper.decorator.MultiPage;
import com.orion.zd.scraper.impl.SoldListingScraperImpl;
import com.orion.zd.service.SoldListingService;


@Component
@Configuration
@EnableScheduling
public class AllSoldListing {
	public static int[] randomTable = null;
	public static int index = 0;
	
	@Autowired
	private SoldListingService soldListingService;
	
	//@Scheduled(fixedDelay=60000)
	private void execute(){
		if(randomTable == null){
			creationRandomTable();
		}
		job();
		
	}
	private void job(){
		if(index <= 2612){
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
	private void creationRandomTable(){
		randomTable = new int[2613];
		for(int i=0;i<2613;i++){
			randomTable[i] = i+1;
		}
		for(int i=0;i<100000;i++){
			int random1 = 0 + (int)(Math.random() * ((2612 - 0) + 0));
			int random2 = 0 + (int)(Math.random() * ((2612 - 0) + 0));
			int temp = randomTable[random1];
			randomTable[random1] = randomTable[random2];
			randomTable[random2] = temp;
		}
	}
}
