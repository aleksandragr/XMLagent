package com.travel.Agent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.gs_ws.GetDistinctCategoriesResponse;
import com.concretepage.gs_ws.GetDistinctServicesResponse;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.AdditionalServicesRepository;
import com.travel.Agent.soap.AccommodationSoap;
import com.travel.Agent.soap.AdditionalServiceSoap;
import com.travel.Agent.soap.CategorySoap;

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
		AdditionalServices ad = additionalServicesRepository.findByIdEquals(id);
		
		return ad;		
	}
	
	
	/**
	 * Vrace sve dodatne usluge kao list stringova koje je admin napravio
	 * 
	 * @return
	 */
	public List<String> getserviceFromMain(){
		
		AdditionalServiceSoap additionalservicesoap = new AdditionalServiceSoap();
		GetDistinctServicesResponse distinctService =  additionalservicesoap.additionalServiceSoap("getServices");
		
		ArrayList<String> services = new ArrayList<>();
		if(distinctService!=null) {
			services.addAll(distinctService.getServices());
		}
		
		
		return services;
	}
	
	public List<AdditionalServices> getAllAS(){
		
		List<AdditionalServices> as = additionalServicesRepository.findAll();
		
		return as;
	}
	
	
	
	
	public List<String> getCategory(){
		
		CategorySoap catsoap = new CategorySoap();
		GetDistinctCategoriesResponse getcate = catsoap.additionalServiceSoap("getCategory");
		
		List<String> stringoi = new ArrayList<>();
		for(int i = 0 ;i<getcate.getCategories().size();i++) {
			stringoi.add(getcate.getCategories().get(i));
		}
		
		return stringoi;
	}
	
}
