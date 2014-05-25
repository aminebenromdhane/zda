package com.orion.zd.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class NotStandardFileReader {
	
	private String fileUrl;
	private Hashtable<String,ArrayList<String>> fileData;
	private String[] header;
	
	public NotStandardFileReader(String fileUrl){
		this.fileUrl = fileUrl;
		fileData = new Hashtable<String,ArrayList<String>>();
		connect();
	}
	
	private void connect(){
		HttpURLConnection connection = null;
	    try {
	        URL url = new URL(fileUrl.toString());
	        connection = (HttpURLConnection) url.openConnection();
	        connection.connect();
	        read(connection.getInputStream());
	    } catch (MalformedURLException e1) {
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    } finally {
	        if(null != connection) { connection.disconnect(); }
	    }
	}
	
	private void read(InputStream input){
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        int i=0;
        try {
			while ((line = reader.readLine()) != null) {
				if(i > 1){ 
					setRow(line);
				}else if(i == 1){
					setHeader(line);
				}//ignore first line
				i++;
			}
			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private void setHeader(String line){
		ArrayList<String> header = splitLine(line);
		this.header = new String[header.size()];
		int i=0;
		for(String columnName : header){
			fileData.put(columnName,new ArrayList<String>());
			this.header[i] = columnName;
			i++;
		}
	}
	private void setRow(String line){
		ArrayList<String> row = splitLine(line);
		int i=0;
		for(String key : header){
			fileData.get(key).add(row.get(i));
			i++;
		}
	}
	private ArrayList<String> splitLine(String line){
		ArrayList<String> splittedLine = new ArrayList<String>();
		line = line.replace("|", "@@");
		String[] fields = line.split("@@");
		for(int i=0;i<fields.length;i++){
			splittedLine.add(fields[i].trim());
		}
		return splittedLine;
	}
	public String[] getHeader(){
		return this.header;
	}
	public Hashtable<String,ArrayList<String>> getFileData(){
		return this.fileData;
	}
	public int countRow(){
		return this.fileData.get(header[0]).size();
	}
	
}
