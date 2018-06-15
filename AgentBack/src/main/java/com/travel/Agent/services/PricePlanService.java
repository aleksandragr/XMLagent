package com.travel.Agent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.dto.PricePlanDTO;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.PricePlan;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.PricePlanRepository;

@Service
public class PricePlanService {

	@Autowired
	private PricePlanRepository pricePlanRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository; 
	
	public PricePlanDTO addPricePlan(PricePlanDTO pricePdto) {
		
		Accommodation accommodation = accommodationRepository.findByIdEquals(Long.valueOf(pricePdto.getIdAccommodation())); 
		
		PricePlan pricePlan1 = new PricePlan();
		pricePlan1.setAccommodation(accommodation);
		pricePlan1.setRoomType(pricePdto.getRoomType());
		pricePlan1.setMonth(1);
		pricePlan1.setPrice(pricePdto.getJanuary());
		pricePlanRepository.save(pricePlan1);
		
		PricePlan pricePlan2 = new PricePlan();
		pricePlan2.setAccommodation(accommodation);
		pricePlan2.setRoomType(pricePdto.getRoomType());
		pricePlan2.setMonth(2);
		pricePlan2.setPrice(pricePdto.getFebruary());
		pricePlanRepository.save(pricePlan2);
		
		PricePlan pricePlan3 = new PricePlan();
		pricePlan3.setAccommodation(accommodation);
		pricePlan3.setRoomType(pricePdto.getRoomType());
		pricePlan3.setMonth(3);
		pricePlan3.setPrice(pricePdto.getMarch());
		pricePlanRepository.save(pricePlan3);
		
		PricePlan pricePlan4 = new PricePlan();
		pricePlan4.setAccommodation(accommodation);
		pricePlan4.setRoomType(pricePdto.getRoomType());
		pricePlan4.setMonth(4);
		pricePlan4.setPrice(pricePdto.getApril());
		pricePlanRepository.save(pricePlan4);
		
		PricePlan pricePlan5 = new PricePlan();
		pricePlan5.setAccommodation(accommodation);
		pricePlan5.setRoomType(pricePdto.getRoomType());
		pricePlan5.setMonth(5);
		pricePlan5.setPrice(pricePdto.getMay());
		pricePlanRepository.save(pricePlan5);
		
		PricePlan pricePlan6 = new PricePlan();
		pricePlan6.setAccommodation(accommodation);
		pricePlan6.setRoomType(pricePdto.getRoomType());
		pricePlan6.setMonth(6);
		pricePlan6.setPrice(pricePdto.getJune());
		pricePlanRepository.save(pricePlan6);
		
		PricePlan pricePlan7 = new PricePlan();
		pricePlan7.setAccommodation(accommodation);
		pricePlan7.setRoomType(pricePdto.getRoomType());
		pricePlan7.setMonth(7);
		pricePlan7.setPrice(pricePdto.getJuly());
		pricePlanRepository.save(pricePlan7);
		
		PricePlan pricePlan8 = new PricePlan();
		pricePlan8.setAccommodation(accommodation);
		pricePlan8.setRoomType(pricePdto.getRoomType());
		pricePlan8.setMonth(8);
		pricePlan8.setPrice(pricePdto.getAugust());
		pricePlanRepository.save(pricePlan8);
		
		PricePlan pricePlan9 = new PricePlan();
		pricePlan9.setAccommodation(accommodation);
		pricePlan9.setRoomType(pricePdto.getRoomType());
		pricePlan9.setMonth(9);
		pricePlan9.setPrice(pricePdto.getSeptember());
		pricePlanRepository.save(pricePlan9);
		
		PricePlan pricePlan10 = new PricePlan();
		pricePlan10.setAccommodation(accommodation);
		pricePlan10.setRoomType(pricePdto.getRoomType());
		pricePlan10.setMonth(10);
		pricePlan10.setPrice(pricePdto.getOctober());
		pricePlanRepository.save(pricePlan10);
		
		PricePlan pricePlan11 = new PricePlan();
		pricePlan11.setAccommodation(accommodation);
		pricePlan11.setRoomType(pricePdto.getRoomType());
		pricePlan11.setMonth(11);
		pricePlan11.setPrice(pricePdto.getNovember());
		pricePlanRepository.save(pricePlan11);
		
		PricePlan pricePlan12 = new PricePlan();
		pricePlan12.setAccommodation(accommodation);
		pricePlan12.setRoomType(pricePdto.getRoomType());
		pricePlan12.setMonth(12);
		pricePlan12.setPrice(pricePdto.getDecember());
		pricePlanRepository.save(pricePlan12);
		
		return pricePdto;
	}
	
}
