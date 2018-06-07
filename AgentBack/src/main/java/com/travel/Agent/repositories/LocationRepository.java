package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findByIdEquals(Long id);
}
