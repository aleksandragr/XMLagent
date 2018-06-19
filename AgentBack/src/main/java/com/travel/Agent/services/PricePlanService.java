package com.travel.Agent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.dto.PricePlanDTO;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.PricePlan;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.PricePlanRepository;
import com.travel.Agent.soap.PricePlanSoap;

@Service
public class PricePlanService {

	@Autowired
	private PricePlanRepository pricePlanRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository; 
	
	public PricePlanDTO addPricePlan(PricePlanDTO pricePdto) {
		
		Accommodation accommodation = accommodationRepository.findByIdEquals(Long.valueOf(pricePdto.getIdAccommodation())); 
		
		PricePlan plan = new PricePlan();
		
		plan.setAccommodation(accommodation);
		plan.setRoomType(pricePdto.getRoomType());
		plan.setJanuary(pricePdto.getJanuary());
		plan.setFebruary(pricePdto.getFebruary());
		plan.setMarch(pricePdto.getMarch());
		plan.setApril(pricePdto.getApril());
		plan.setMay(pricePdto.getMay());
		plan.setJune(pricePdto.getJune());
		plan.setJuly(pricePdto.getJuly());
		plan.setAugust(pricePdto.getAugust());
		plan.setSeptember(pricePdto.getSeptember());
		plan.setOctober(pricePdto.getOctober());
		plan.setNovember(pricePdto.getNovember());
		plan.setDecember(pricePdto.getDecember());
		
		pricePlanRepository.save(plan);
		
		PricePlanSoap pps = new PricePlanSoap();
		pps.pricePlanSoap("addPricePlan", pricePdto);
		
		return pricePdto;
	}
	
}
