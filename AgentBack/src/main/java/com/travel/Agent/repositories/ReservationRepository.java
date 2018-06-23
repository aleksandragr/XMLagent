package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
	Reservation findByIdEquals(Long id);
}
