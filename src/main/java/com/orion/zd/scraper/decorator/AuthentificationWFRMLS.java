package com.orion.zd.scraper.decorator;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;

import com.orion.zd.scraper.component.Scraper;
import com.orion.zd.scraper.component.ScraperUrl;

public abstract class AuthentificationWFRMLS extends Authentification{

	public AuthentificationWFRMLS(Scraper scraper) {
		super(scraper);
	}
	
	@Override
	public void authentificate(){
		super.authentificate();
		this.initSearch();
	}
	
	protected abstract void initSearch();

}
