package com.travel.Agent.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.dto.PricePlanDTO;
import com.travel.Agent.services.PricePlanService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/priceplan")
public class PricePlanController {
	
	
	@Autowired
	private PricePlanService pricePlanService;
	
	@PostMapping("/addpriceplan")
	public ResponseEntity<List<PricePlanDTO>> addpriceplan(@RequestBody PricePlanDTO pricePlanDto){
		
		List<PricePlanDTO> pricePlans = pricePlanService.addPricePlan(pricePlanDto);
		
		if(pricePlans!=null) {
			return new ResponseEntity<>(pricePlans,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
