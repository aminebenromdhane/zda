package com.orion.zd.cron;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.orion.zd.domain.Street;
import com.orion.zd.reader.NotStandardFileReader;
import com.orion.zd.service.StreetService;

@Component
@Configuration
@EnableScheduling
public class StreetsInformationSaltLake {
	
	@Autowired
	private StreetService streetService;
	
	//@Scheduled(initialDelay=1000, fixedRate=2592000)
	private void execute(){
		NotStandardFileReader reader = new NotStandardFileReader("http://www.slco.org/pw/addressing/html/ytdstreets.txt");
		Hashtable<String,ArrayList<String>> streetInformation = reader.getFileData();
		for(int i=0;i<reader.countRow();i++){
			Street street = new Street();
			try{
				street.setZip(Integer.parseInt(streetInformation.get("ZIP-CODE").get(i)));
				street.setName(streetInformation.get("STREET-NAME").get(i));
				street.setType(streetInformation.get("TYPE").get(i));
			}catch(Exception e){
				continue;
			}
			if(streetService.getStreetID(street) == null){
				streetService.insertStreet(street);
			}
		}
		
	}
	
}
