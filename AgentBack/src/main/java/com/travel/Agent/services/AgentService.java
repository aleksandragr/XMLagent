package com.travel.Agent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.dto.AgentDTO;
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
	
	public Agent login(String email, String password) {
		
		Agent agent1 = agentRepository.findByEmailEqualsAndPasswordEquals(email, password);
		if(agent1!=null) {
			if(agent1.isApproved())
				return agent1;
		
		}
		return null;
	}
	
	public Agent registration(AgentDTO agent) {
		
		Agent agent1 = new Agent();
		
		if(agent.getNewPassword().equals(agent.getRepeatPassword())) {
			agent1.setName(agent.getName());
			agent1.setPassword(agent.getPassword());
			agent1.setEmail(agent.getEmail());
			agent1.setPassword(agent.getNewPassword());
			agent1.setAddress(agent.getAddress());
			agent1.setBusinessRegNum(agent.getBusinessRegNum());
			//treba staviti na false kad uradimo odobravanje admina
			agent1.setApproved(true);
			
			Agent a = agentRepository.findByEmailEquals(agent1.getEmail());
			if(a==null) {
				return agentRepository.save(agent1);
			}
				
		}
		
		return null;
	}
	
	

}
