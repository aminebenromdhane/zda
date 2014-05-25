package com.orion.zd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion.zd.domain.FSBO;
import com.orion.zd.persistence.FSBOMapper;

@Service
public class FSBOService {

	@Autowired
	private FSBOMapper fsboMapper;
	
	public void insertFSBO(FSBO fsbo){
		fsboMapper.insertFSBO(fsbo);
	}
	
	public FSBO getFSBO(long parcel){
		return fsboMapper.getFSBO(parcel);
	}
	
	public List<FSBO> getAllFSBO(){
		return fsboMapper.getAllFSBO();
	}
}
