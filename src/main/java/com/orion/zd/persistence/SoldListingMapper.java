package com.orion.zd.persistence;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.orion.zd.domain.SoldListing;

public interface SoldListingMapper {
	
	public SoldListing getListing(int mls);
	
	public void addListing(SoldListing soldListing);

	public List<SoldListing> getAllListing(@Param("type") String type,@Param("style") String style,@Param("zip") int zip,@Param("firstDate") Date firstDate,@Param("lastDate") Date lastDate);
}
