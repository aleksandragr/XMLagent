package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{
	
	Agent findByIdEquals(Long id);
	
	Agent findByEmailEqualsAndPasswordEquals(String email, String password);
	
	Agent findByEmailEquals(String email);

}
