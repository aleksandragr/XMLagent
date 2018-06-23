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
		
		if(pricePdto.getRoomType()!=0) {
			
			PricePlan pp = pricePlanRepository.findByRoomTypeEqualsAndAccommodation_idEquals(pricePdto.getRoomType(), accommodation.getId());
			
			if(pp==null) {
			
				
				
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
				pps.pricePlanSoap("addPricePlan", plan);
		
				
				
				
				return pricePdto;
			}
			else if(pp!=null) {
				
				
				
				
				pp.setAccommodation(accommodation);
				pp.setRoomType(pricePdto.getRoomType());
				pp.setJanuary(pricePdto.getJanuary());
				pp.setFebruary(pricePdto.getFebruary());
				pp.setMarch(pricePdto.getMarch());
				pp.setApril(pricePdto.getApril());
				pp.setMay(pricePdto.getMay());
				pp.setJune(pricePdto.getJune());
				pp.setJuly(pricePdto.getJuly());
				pp.setAugust(pricePdto.getAugust());
				pp.setSeptember(pricePdto.getSeptember());
				pp.setOctober(pricePdto.getOctober());
				pp.setNovember(pricePdto.getNovember());
				pp.setDecember(pricePdto.getDecember());
				
				pricePlanRepository.save(pp);
				
				PricePlanSoap pps = new PricePlanSoap();
				pps.pricePlanSoap("addPricePlan", pp);
				
				
				return pricePdto;
				
			}
		}
		return null;
	}
	
}
