package com.orion.zd.persistence;

import java.util.List;

import com.orion.zd.domain.Street;

public interface StreetMapper {

	public void insertStreet(Street street);
	
	public Street getStreetID(Street street);
	
	public List<Street> getAllStreets();
  
}

