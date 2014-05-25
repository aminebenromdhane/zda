package com.orion.zd.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orion.zd.estimator.ZoomEstimator;
import com.orion.zd.service.SoldListingService;

@Controller
public class HomeController {
	
	@Autowired
	private SoldListingService soldListingService;
	
	@RequestMapping(value = "/estimator", method = RequestMethod.GET)
	public String homeEstimator(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "sold";
	}
	
}
