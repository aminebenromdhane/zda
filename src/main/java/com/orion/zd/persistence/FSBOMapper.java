package com.orion.zd.persistence;

import java.util.List;

import com.orion.zd.domain.FSBO;


public interface FSBOMapper {
	
	public void insertFSBO(FSBO fsbo);
	
	public FSBO getFSBO(long parcel);
	
	public List<FSBO> getAllFSBO();
}
