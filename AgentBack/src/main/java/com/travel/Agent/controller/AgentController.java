package com.travel.Agent.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.dto.AgentDTO;
import com.travel.Agent.model.Agent;
import com.travel.Agent.services.AgentService;

@RestController
@RequestMapping(value="agent")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@GetMapping(value="/getAllAgents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		List<Agent> agents = agentService.getAll();
		
		if(agents==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(agents,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Agent> getAgent(@PathVariable Long id){		
		Agent agent = agentService.getAgent(id);
		
		if(agent==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Agent>(agent, HttpStatus.OK);
	}
	
	@PostMapping(value="/addAgent")
	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
		
		Agent agent1 =agentService.addAgent(agent);
		
		if(agent1==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(agent1,HttpStatus.OK);	
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Agent> loginAgent(@RequestBody Agent agent){
		
		Agent agent1 = agentService.login(agent.getEmail(), agent.getPassword());
		
		if(agent1==null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<>(agent1,HttpStatus.OK);
	}
	
	@PostMapping(value="/registration")
	public ResponseEntity<Agent> registrationAgent(@RequestBody AgentDTO agent){
		
		Agent agent1 = agentService.registration(agent);
		
		if(agent1==null) 
			return new ResponseEntity<>(agent1,HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<>(agent1,HttpStatus.OK);	
	}

}
