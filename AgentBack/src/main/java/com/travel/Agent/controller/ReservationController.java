package com.travel.Agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.Accommodation;
import com.travel.Agent.model.Reservation;
import com.travel.Agent.services.ReservationService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/getReservationOfAgent/{id}")
	public ResponseEntity<List<Reservation>> gerReservation(@PathVariable Long id){
		
		List<Reservation> reservations = reservationService.getReservation(id);
		
		if(reservations!=null) {
			return new ResponseEntity<>(reservations,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/acceptreservation/{id}")
	public ResponseEntity<Reservation> acceptReservation(@PathVariable Long id){
		
		Reservation reservation = reservationService.acceptReservation(id);
		
		if(reservation!=null) {
			return new ResponseEntity<>(reservation,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/deletereservation/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id){
		
		Reservation reservation = reservationService.deleteReservation(id);
		
		if(reservation!=null) {
			return new ResponseEntity<>(reservation,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
