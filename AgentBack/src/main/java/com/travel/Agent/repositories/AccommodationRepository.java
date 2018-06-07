package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.Agent.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	Accommodation findByIdEquals(Long id);
}
