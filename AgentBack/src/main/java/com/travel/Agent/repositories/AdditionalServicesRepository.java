package com.travel.Agent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.AdditionalServices;

@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long> {

	AdditionalServices findByIdEquals(Long id);
	
	List<AdditionalServices> findByAccommodation_IdEquals(Long id);
}
