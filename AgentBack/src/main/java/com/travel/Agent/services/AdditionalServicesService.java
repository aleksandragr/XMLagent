package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.repositories.AdditionalServicesRepository;

@Service
public class AdditionalServicesService {

	@Autowired
	private AdditionalServicesRepository additionalServicesRepository;
	
	
	public AdditionalServices addAdditionalServices(AdditionalServices addSer) {
		
		AdditionalServices additionalServices = additionalServicesRepository.save(addSer);
		
		return additionalServices;
		
	}
	
	public AdditionalServices findAS(Long id) {
		
		AdditionalServices ad = additionalServicesRepository.findByIdEquals(id);
		
		return ad;		
	}
	
}
