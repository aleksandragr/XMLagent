package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.Location;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AccommodationRepository accommodationRep;
	
	
	public Location addLocation(Location loc) {
		
		Location location = locationRepository.save(loc);
		
		return location;
	}
	
	public Location findLocation(Long id) {
		
		Accommodation accommodation = accommodationRep.findByIdEquals(id);
		Location location = locationRepository.findByIdEquals(accommodation.getLocation().getId());
		
		return location;
	}
}
