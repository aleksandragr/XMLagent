package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.AdditionalServicesRepository;

@Service
public class AdditionalServicesService {

	@Autowired
	private AdditionalServicesRepository additionalServicesRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	public AdditionalServices addAdditionalServices(AdditionalServices addSer) {
		
		AdditionalServices additionalServices = additionalServicesRepository.save(addSer);
		
		return additionalServices;
		
	}
	
	public AdditionalServices findAS(Long id) {
		
		Accommodation accommodation = accommodationRepository.findByIdEquals(id);
		AdditionalServices ad = additionalServicesRepository.findByIdEquals(accommodation.getAdditionalServices().getId());
		
		return ad;		
	}
	
}
