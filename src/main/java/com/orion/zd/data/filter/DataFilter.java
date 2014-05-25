package com.orion.zd.data.filter;

import java.util.Date;

public abstract class DataFilter {
	
	protected static int priceFilter(String data){
		if(!data.equals("") && data != null){
			return intFilter(data.replace("$", "").replace(",", ""));
		}
		return 0;
	}
	protected static Date dateFilter(String data){
		try{
			return new Date(data);
		}catch(Exception e){
			return new Date("00/00/0000");
		}
	}
	protected static int intFilter(String data){
		try{
			return Integer.parseInt(data);
		}catch(Exception e){
			return 0;
		}
	}
	protected static double doubleFilter(String data){
		try{
			return Double.parseDouble(data);
		}catch(Exception e){
			return 0;
		}
	}
	protected static float floatFilter(String data){
		try{
			return Float.parseFloat(data);
		}catch(Exception e){
			return 0;
		}
	}
	protected static String middleFilter(String data,String delim1,String delim2){
		if(data != null && !data.equals("")){
			if(data.indexOf(delim1) != -1 && data.indexOf(delim2) != -1){
				return data.substring(data.indexOf(delim1)+delim1.length(), data.indexOf(delim2));
			}
		}
		return "";
	}
}
