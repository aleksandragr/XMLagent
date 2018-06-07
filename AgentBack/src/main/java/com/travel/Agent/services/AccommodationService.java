package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Accommodation;
import com.travel.Agent.repositories.AccommodationRepository;

@Service
public class AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	
	public Accommodation addaccommodation(Accommodation acc) {
		
		Accommodation accommodation = accommodationRepository.save(acc);
		
		return accommodation;
	}
	
}
