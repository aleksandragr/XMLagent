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
import com.travel.Agent.soap.AccommodationSoap;

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
		//long agentid = acc.getIdAgent();
		int y = 1;
		Long id = new Long(y);
		Agent agent = agentRepository.findByIdEquals(id);
		
		
		//careate ACCOMMODATION
		Accommodation accommodation = new Accommodation();
		accommodation.setName(acc.getName());
		accommodation.setType(acc.getType());
		accommodation.setDescription(acc.getDescription());
		accommodation.setRating(acc.getRating());
		accommodation.setFree(true);
		accommodation.setCategory(acc.getCategory());
		
		accommodation.setAdditionalServices(additionalServices);
		accommodation.setLocation(location);
		accommodation.setAgent(agent);
		
		accommodationRepository.save(accommodation);
		
		AccommodationSoap accommodationsopa = new AccommodationSoap();
		accommodationsopa.accommodationSoap("addAccommodation",acc);
		
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
	
	public Accommodation editAcc(Long id, AccommodationDTO acc) {
		
		Accommodation accommodation1=accommodationRepository.findByIdEquals(id);
		if(accommodation1!=null) {
			accommodation1.setName(acc.getName());
			accommodation1.setType(acc.getType());
			accommodation1.setDescription(acc.getDescription());
			accommodation1.setRating(acc.getRating());
			accommodation1.setFree(acc.isFree());
			accommodation1.setCategory(acc.getCategory());
		
			//location
		
			Location location = locationRepository.findByIdEquals(accommodation1.getLocation().getId());
		
			location.setCountry(acc.getCountry());
			location.setCity(acc.getCity());
			location.setAddress(acc.getAddress());
		
			//additionalservices
		
			AdditionalServices ad = additionalServicesRepository.findByIdEquals(accommodation1.getAdditionalServices().getId());
		
			ad.setWiFi(acc.isWiFi());
			ad.setTV(acc.isTv());
			ad.setParking(acc.isParking());
			ad.setKitchen(acc.isKitchen());
			ad.setBreakfast(acc.isBreakfast());
			ad.setHalfBoard(acc.isHalfBoard());
			ad.setFullBoard(acc.isFullBoard());
			ad.setBathroom(acc.isBathroom());
		
			accommodationRepository.save(accommodation1);
			locationRepository.save(location);
			additionalServicesRepository.save(ad);
			
			
			return accommodation1;
		}
		return null;
	}
	
}
