package com.orion.zd.cron;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.orion.zd.domain.FSBO;
import com.orion.zd.scraper.component.Scraper;
import com.orion.zd.scraper.component.ScraperUrl;
import com.orion.zd.scraper.component.SimpleScraper;
import com.orion.zd.service.FSBOService;



@Component
@Configuration
@EnableScheduling
public class FSBOSaltLake {
	
	@Autowired
	private FSBOService fsbo;
	
	//@Scheduled(initialDelay=1000, fixedRate=6000000)
	private void execute(){
		for(int i='A';i<='Z';i++){
			System.out.println(i);
			Scraper linkScraper = new SimpleScraper(new ScraperUrl("http://assessor.slco.org/cfml/Query/resultsMain.cfm?RequestTimout=20"),"linksFSBOSL.xml");
			linkScraper.getUrlToScrap().addDataToSend("street_name", Character.toString((char)i));
			linkScraper.getUrlToScrap().setReferrer("http://assessor.slco.org/cfml/Query/query2.cfm");
			linkScraper.scrap();
			for(Hashtable<String,String> link : linkScraper.getScrappedData()){
				String listingLink = link.get("link");
				Scraper listingScraper = new SimpleScraper(new ScraperUrl("http://assessor.slco.org/cfml/Query/"+listingLink),"listingsFSBOSL.xml");
				listingScraper.scrap();
				ArrayList<Hashtable<String,String>> listingData = listingScraper.getScrappedData();
				this.saveListing(listingData.get(0));
			}
		}
	}
	private void saveListing(Hashtable<String,String> listingData){
		System.out.println(Long.parseLong(listingData.get("parcel").replace("-", "").replace(" ","").replace("\u00a0","")));
		if(fsbo.getFSBO(Long.parseLong(listingData.get("parcel").replace("-", "").replace(" ","").replace("\u00a0",""))) == null){
			FSBO newFSBO = new FSBO();
			newFSBO.setParcel(Long.parseLong(listingData.get("parcel").replace("-", "").replace(" ","").replace("\u00a0","")));
			newFSBO.setAddress(listingData.get("address"));
			newFSBO.setOwner(listingData.get("owner"));
			try{
				newFSBO.setSqft(Integer.parseInt(listingData.get("sqft")));
			}catch(Exception e){
			}
			newFSBO.setAcres(Double.parseDouble(listingData.get("acres")));
			newFSBO.setImage(listingData.get("image"));
			newFSBO.setMarketValue(Integer.parseInt(listingData.get("marketValue").replace("$", "").replace(",", "").replace(".", "").replace(" ","")));
			fsbo.insertFSBO(newFSBO);
		}
	}
	
	
}
