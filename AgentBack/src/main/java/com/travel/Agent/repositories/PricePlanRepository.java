package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.PricePlan;

@Repository
public interface PricePlanRepository extends JpaRepository<PricePlan, Long> {

	PricePlan findByIdEquals(Long id);
	
}
