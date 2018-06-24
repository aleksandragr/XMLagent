package com.travel.Agent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.gs_ws.GetAgentReservationListResponse;
import com.travel.Agent.model.Reservation;
import com.travel.Agent.repositories.AccommodationRepository;
import com.travel.Agent.repositories.ReservationRepository;
import com.travel.Agent.soap.ReservationSoap;

@Service
public class ReservationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getReservation(Long id){
		
		ReservationSoap reservationsoap = new ReservationSoap();
		GetAgentReservationListResponse listRes = reservationsoap.getReservationsSoap("getReservations",id);
		
		List<Reservation> listReservations = new ArrayList<>();
		
		for(int i = 0; i<listRes.getReservation().size();i++) {
			Reservation res = new Reservation();
			
			res.setId(listRes.getReservation().get(i).getId());
			res.setEmail(listRes.getReservation().get(i).getEmail());
			res.setName(listRes.getReservation().get(i).getName());
			res.setSurname(listRes.getReservation().get(i).getSurname());
			res.setStartDate(listRes.getReservation().get(i).getStartDate());
			res.setEndDate(listRes.getReservation().get(i).getEndDate());
			res.setAccepted(listRes.getReservation().get(i).isAccepted());
			res.setDeleted(listRes.getReservation().get(i).isDeleted());
			//res.setRegUser(listRes.getReservation().get(i).getRegUser());
			res.setPrice(listRes.getReservation().get(i).getPrice());
			res.setRoomType(listRes.getReservation().get(i).getRoomType());
			res.setAccommodation(accommodationRepository.findByIdEquals(listRes.getReservation().get(i).getAccommodation().getId()));

			if(!res.isDeleted()) {
				if(!res.isAccepted()) {
					listReservations.add(res);
					reservationRepository.save(res);
					
				}			
			}
			
			
		}
		
		return listReservations;
	}
	
	public Reservation acceptReservation(Long id) {
		
		Reservation res = reservationRepository.findByIdEquals(id);
		
		if(res!=null) {
			res.setAccepted(true);
			reservationRepository.save(res);
			
		}
		
		ReservationSoap reservationsoap = new ReservationSoap();
		GetAgentReservationListResponse listRes = reservationsoap.getReservationsSoap("acceptRegistration",id);
		
		return res;
	}
	
	
	public Reservation deleteReservation(Long id) {
		
		Reservation res = reservationRepository.findByIdEquals(id);
		
		if(res!=null) {
			res.setDeleted(true);
			reservationRepository.save(res);
			
		}
		
		ReservationSoap reservationsoap = new ReservationSoap();
		GetAgentReservationListResponse listRes = reservationsoap.getReservationsSoap("deleteRegistration",id);
		
		return res;
	}
	
}
