package com.orion.zd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion.zd.domain.Street;
import com.orion.zd.persistence.StreetMapper;


@Service
public class StreetService {

	@Autowired
	private StreetMapper streetMapper;

	public void insertStreet(Street street){
		streetMapper.insertStreet(street);
	}
	
	public Street getStreetID(Street street){
		return streetMapper.getStreetID(street);
	}
	
	public List<Street> getAllStreets(){
		return streetMapper.getAllStreets();
	}
	
	public List<String> getAllStreetsNames(){
		List<String> allStreetsNames = new ArrayList<String>();
		for(Street street:this.getAllStreets()){
			allStreetsNames.add(street.getName());
		}
		return allStreetsNames;
	}
}
