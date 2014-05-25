package com.orion.zd.data.filter;

import java.util.Date;

public class SoldListingFilter extends DataFilter{
	
	public static int mls(String data){
		return intFilter(data.replace("MLS#", "").trim());
	}
	public static String bac(String data){
		return data.trim();
	}
	public static String type(String data){
		return data.trim();
	}
	public static String address(String data){
		return data.trim();
	}
	public static String sellerOffice(String data){
		return middleFilter(data,"/id/","/state/");
	}
	public static String listingOffice(String data){
		return middleFilter(data,"/id/","/state/");
	}
	public static int bed(String data){
		return intFilter(data);
	}
	public static Date soldDate(String data){
		return dateFilter(data);
	}
	public static int bath(String data1,String data2,String data3){
		return intFilter(data1)+intFilter(data2)+intFilter(data3);
	}
	public static int year(String data){
		return intFilter(data);
	}
	public static Date listDate(String data){
		return dateFilter(data);
	}
	public static double longitude(String data){
		return doubleFilter(middleFilter(data,"/lng/","/list/"));
	}
	public static double latitude(String data){
		return doubleFilter(middleFilter(data,"/lat/","/lng/"));
	}
	public static float acres(String data){
		return floatFilter(data);
	}
	public static String image(String data){
		return data.trim();
	}
	public static int listPrice(String data){
		return priceFilter(data);
	}
	public static int soldPrice(String data){
		return priceFilter(data);
	}
	public static int zip(String data){
		if(data.length()-(data.indexOf(" UT ")+3) >= 5){
			return intFilter(data.substring(data.indexOf(" UT ")+4));
		}
		return 0;
	}
	public static String brokerage(String data){
		return middleFilter(data,"/id/","/state/");
	}
	public static String sellerAgent(String data){
		return middleFilter(data,"/id/","/state/");
	}
	public static String listingAgent(String data){
		return middleFilter(data,"/id/","/state/");
	}
	public static int sqft(String data){
		return intFilter(data);
	}
	public static int garage(String data){
		return intFilter(data);
	}
	public static String style(String data){
		return data.trim();
	}
	public static String city(String data){
		if(data.indexOf(",") == -1){
			return data.substring(0, data.indexOf(","));
		}
		return data;
	}
}
