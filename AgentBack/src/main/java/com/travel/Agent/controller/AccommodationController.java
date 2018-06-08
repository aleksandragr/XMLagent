package com.travel.Agent.controller;

import java.util.List;

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

import com.travel.Agent.dto.AccommodationDTO;
import com.travel.Agent.model.Accommodation;
import com.travel.Agent.services.AccommodationService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/accommodation")
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;
	
	
	/**
	 * 
	 * Add new accommodation
	 * @param accommodation
	 * @return accommodation
	 */
	@PostMapping("/addAccommodation")
	public ResponseEntity<Accommodation> addAccommodation(@RequestBody AccommodationDTO accommodation) {
		
		Accommodation acc = accommodationService.addaccommodation(accommodation);
		
		if(acc!=null) {
			return new ResponseEntity<>(acc, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/getAccommodation/{id}")
	public ResponseEntity<Accommodation> getAccommodation(@PathVariable Long id){
		
		Accommodation accommodation = accommodationService.findAccommodation(id);
		
		if(accommodation!=null) {
			return new ResponseEntity<>(accommodation,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * get all accommodation of agent
	 * @param id of agent
	 * @return all accommodations
	 */
	@GetMapping("/getAllAccommodation/{id}")
	public ResponseEntity<List<Accommodation>> getAllAccommodationOfAgent(@PathVariable Long id){
		
		List<Accommodation> accommodations = accommodationService.getallAccOfAgent(id);
		
		if(accommodations!=null) {
			return new ResponseEntity<>(accommodations,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
