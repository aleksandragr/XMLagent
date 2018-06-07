package com.travel.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.Location;
import com.travel.Agent.services.LocationService;

@RestController
@RequestMapping(value="/location")
public class LocationController {

	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/addLocation")
	public ResponseEntity<Location> addLocation(@RequestBody Location loc){
		
		Location location = locationService.addLocation(loc);
		
		if(location!=null) {
			return new ResponseEntity<>(location,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
