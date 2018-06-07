package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Location;
import com.travel.Agent.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	
	public Location addLocation(Location loc) {
		
		Location location = locationRepository.save(loc);
		
		return location;
	}
}
