package com.orion.zd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orion.zd.estimator.ZoomEstimator;
import com.orion.zd.service.SoldListingService;

@RestController
public class EstimatorController {
	
	@Autowired
	private SoldListingService soldListingService;
	
	@RequestMapping(value = "estimator/estimate")
	public String estimate(@RequestParam(value = "yearBuilt") double yearBuilt,
							@RequestParam(value = "zip") int zip,
							@RequestParam(value = "type") String type,
							@RequestParam(value = "style") String style,
							@RequestParam(value = "soldYear") int soldYear,
							@RequestParam(value = "acres") double acres,
							@RequestParam(value = "bath") double bath,
							@RequestParam(value = "bed") double bed,
							@RequestParam(value = "sqft") double sqft,
							@RequestParam(value = "garage") double garage) {
		ZoomEstimator zoomestimator = new ZoomEstimator(soldListingService.getAllListing(zip,type,style,soldYear));		
		//return zoomestimator.getPrice(new double[] {1968.0,0.19,4.0,2.0,2038.0,0.0});
		int tries = 1000; 
		double sum = 0;
		for(int i=0;i<tries;i++){
			System.out.println("TRY : "+(i+1));
			zoomestimator.learn();
			sum += zoomestimator.getPrice(new double[] {yearBuilt,acres,bed,bath,sqft,garage});
		}
		return String.valueOf(sum/tries);
	}
}
