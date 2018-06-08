package com.travel.Agent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.dto.AccommodationDTO;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.model.Agent;
import com.travel.Agent.model.Location;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.AdditionalServicesRepository;
import com.travel.Agent.repositories.AgentRepository;
import com.travel.Agent.repositories.LocationRepository;

@Service
public class AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private AdditionalServicesRepository additionalServicesRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	
	
	
	public Accommodation addaccommodation(AccommodationDTO acc) {
		
		//create ADDITIONAL SERVICES
		AdditionalServices additionalServices = new AdditionalServices();
		
		additionalServices.setBathroom(acc.isBathroom());
		additionalServices.setBreakfast(acc.isBreakfast());
		additionalServices.setFullBoard(acc.isFullBoard());
		additionalServices.setHalfBoard(acc.isHalfBoard());
		additionalServices.setKitchen(acc.isKitchen());
		additionalServices.setParking(acc.isParking());
		additionalServices.setTV(acc.isTv());
		additionalServices.setWiFi(acc.isWiFi());
		
		additionalServicesRepository.save(additionalServices);
		
		//create LOCATION
		Location location = new Location();
		
		location.setCountry(acc.getCountry());
		location.setCity(acc.getCity());
		location.setAddress(acc.getAddress());
		
		locationRepository.save(location);
		
		//AGENT 
		long agentid = acc.getIdAgent();
		Agent agent = agentRepository.findByIdEquals(agentid);
		
		
		//careate ACCOMMODATION
		Accommodation accommodation = new Accommodation();
		accommodation.setName(acc.getName());
		accommodation.setType(acc.getType());
		accommodation.setDescription(acc.getDescription());
		accommodation.setRating(acc.getRating());
		accommodation.setFree(acc.isFree());
		accommodation.setCategory(acc.getCategory());
		
		accommodation.setAdditionalServices(additionalServices);
		accommodation.setLocation(location);
		accommodation.setAgent(agent);
		
		accommodationRepository.save(accommodation);
		
		
		return accommodation;
	}
	
	
	public Accommodation findAccommodation(Long id) {
		
		Accommodation acc = accommodationRepository.findByIdEquals(id);
		
		return acc;
	}
	
	public List<Accommodation> getallAccOfAgent(Long id){
		
		List<Accommodation> accommodations = accommodationRepository.findByAgent_idEquals(id);
		
		return accommodations;
	}
	
}
