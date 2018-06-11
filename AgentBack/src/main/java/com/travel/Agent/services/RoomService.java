package com.travel.Agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.Agent.model.Room;
import com.travel.Agent.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	public Room addRoom(Room r) {
		
		Room room = roomRepository.save(r);
		return room;
		
	}
	
	
}
