package com.travel.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.Accommodation;
import com.travel.Agent.services.AccommodationService;

@RestController
@RequestMapping(value="/accommodation")
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;
	
	
	@PostMapping("/addAccommodation")
	public ResponseEntity<Accommodation> addAccommodation(@RequestBody Accommodation accommodation) {
		
		Accommodation acc = accommodationService.addaccommodation(accommodation);
		
		if(acc!=null) {
			return new ResponseEntity<>(acc, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
