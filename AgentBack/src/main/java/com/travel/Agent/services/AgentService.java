package com.travel.Agent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Agent;
import com.travel.Agent.repositories.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentRepository;
	
	public List<Agent> getAll(){
		
		List<Agent> agents = agentRepository.findAll();
		return agents;
	}
	
	public Agent getAgent(Long id) {
		
		Agent agent = agentRepository.findByIdEquals(id);
		return agent;
	}
	
	public Agent addAgent(Agent agent) {
		
		Agent agent1 = agentRepository.save(agent);
		
		return agent1;
	}

}
