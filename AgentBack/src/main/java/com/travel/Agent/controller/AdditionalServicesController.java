package com.travel.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.AdditionalServices;
import com.travel.Agent.services.AdditionalServicesService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/additionalServices")
public class AdditionalServicesController {

	@Autowired
	private AdditionalServicesService additionalServicesService;
	
	
	@PostMapping("/addAdditionalS")
	public ResponseEntity<AdditionalServices> addAdditionalS(@RequestBody AdditionalServices additionalS){
		
		AdditionalServices addS = additionalServicesService.addAdditionalServices(additionalS);
		
		if(addS!=null) {
			return new ResponseEntity<>(addS,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<AdditionalServices> getAS(@PathVariable Long id){
		
		AdditionalServices as = additionalServicesService.findAS(id);
		
		if(as==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(as,HttpStatus.OK);
	}
	
}
