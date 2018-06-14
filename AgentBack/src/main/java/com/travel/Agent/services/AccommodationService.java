package com.travel.Agent.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.dto.AccommodationDTO;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.model.Agent;
import com.travel.Agent.model.Location;
import com.travel.Agent.model.Room;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.AdditionalServicesRepository;
import com.travel.Agent.repositories.AgentRepository;
import com.travel.Agent.repositories.LocationRepository;
import com.travel.Agent.repositories.RoomRepository;
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
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private AdditionalServicesService additionalServicesService;
	
	
	public Accommodation addaccommodation(AccommodationDTO acc) {
		
		//create LOCATION
		Location location = new Location();
				
		location.setCountry(acc.getCountry());
		location.setCity(acc.getCity());
		location.setAddress(acc.getAddress());
				
		locationRepository.save(location);
		
		
		//create AGENT 
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
		
		
		accommodation.setLocation(location);
		accommodation.setAgent(agent);
		
		accommodationRepository.save(accommodation);
		
		
		
		//create ADDITIONAL SERVICES
	
		List<String> services = acc.getAditionalServices();
		for(int i = 0; i<services.size();i++) {
			AdditionalServices additionalservice = new AdditionalServices();
			additionalservice.setAccommodation(accommodation);
			additionalservice.setServicename(services.get(i));
			additionalServicesRepository.save(additionalservice);
		}
			
		
		
		//create ROOM
		int jednokrevetne = acc.getOnebeds();
		int dvokrevetne = acc.getTwobeds();
		int trokrevetne = acc.getTheerebeds();
		int cetvorokrevetne = acc.getFourbeds();
		int petokrevetne = acc.getFivebeds();
		
		for(int i=0;i<jednokrevetne;i++) {
			Room room = new Room();
			room.setNumberOfBed(1);
			room.setFree(true);
			room.setAccommodation(accommodation);
			roomRepository.save(room);
		}
		
		
		for(int i=0;i<dvokrevetne;i++) {
			Room room = new Room();
			room.setNumberOfBed(2);
			room.setFree(true);
			room.setAccommodation(accommodation);
			roomRepository.save(room);
		}
		
		for(int i=0;i<trokrevetne;i++) {
			Room room = new Room();
			room.setNumberOfBed(3);
			room.setFree(true);
			room.setAccommodation(accommodation);
			roomRepository.save(room);
		}
		
		for(int i=0;i<cetvorokrevetne;i++) {
			Room room = new Room();
			room.setNumberOfBed(4);
			room.setFree(true);
			room.setAccommodation(accommodation);
			roomRepository.save(room);
		}
		
		for(int i=0;i<petokrevetne;i++) {
			Room room = new Room();
			room.setNumberOfBed(5);
			room.setFree(true);
			room.setAccommodation(accommodation);
			roomRepository.save(room);
		}
		
		
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
		System.out.println(acc.getIdAccommodation());
		Accommodation accommodation1=accommodationRepository.findByIdEquals(id);
		if(accommodation1!=null) {
			accommodation1.setName(acc.getName());
			accommodation1.setType(acc.getType());
			accommodation1.setDescription(acc.getDescription());
			accommodation1.setRating(acc.getRating());
			accommodation1.setFree(acc.isFree());
			accommodation1.setCategory(acc.getCategory());
			acc.setIdAccommodation(accommodation1.getId());
			//location
		
			Location location = locationRepository.findByIdEquals(accommodation1.getLocation().getId());
		
			location.setCountry(acc.getCountry());
			location.setCity(acc.getCity());
			location.setAddress(acc.getAddress());
		
			//additionalservices
			List<AdditionalServices> addS = additionalServicesRepository.findByAccommodation_IdEquals(id);
			for(int i=0; i<addS.size(); i++) {
				additionalServicesRepository.delete(addS.get(i));
			}
			
			List<String> as = acc.getAditionalServices();
			for(int i=0; i<as.size();i++) {
				AdditionalServices addit = new AdditionalServices();
				addit.setServicename(as.get(i));
				addit.setAccommodation(accommodation1);
				additionalServicesRepository.save(addit);
			}
			
			accommodationRepository.save(accommodation1);
			locationRepository.save(location);
			//additionalServicesRepository.save(ad);
			
			AccommodationSoap accommodationSoap = new AccommodationSoap();
			accommodationSoap.accommodationSoap("editAccommodation", acc);
			
			
			return accommodation1;
		}
		return null;
	}
	
	
	public Accommodation reserveAcc(AccommodationDTO acc) {
				
		Accommodation accommodation = accommodationRepository.findByIdEquals(acc.getIdAccommodation());
		
		accommodation.setReservedFrom(acc.getReservedFrom());		
		accommodation.setReservedTo(acc.getReservedTo());	
		accommodation.setFree(false);
		
		accommodationRepository.save(accommodation);
		
		return accommodation;
	}
	
}
