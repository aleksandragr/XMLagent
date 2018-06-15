package com.travel.Agent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
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

	/**
	 * 
	 * @return 
	 * @return tipove soba koje ima accommodation(jednokrevetna,dvokrevetna...)
	 */
	public List<String>  getRoomsOfAccommodation(Long id){
		
		
		List<Room> rooms = roomRepository.findByAccommodation_idEquals(id);
		List<String> typeOfRoom = new ArrayList<>();
		
		for(int i = 0;i<rooms.size();i++) {
			
			if((!typeOfRoom.contains(Integer.toString(rooms.get(i).getNumberOfBed())))) {
				typeOfRoom.add(Integer.toString(rooms.get(i).getNumberOfBed()));
			}
			
		}

		return typeOfRoom;
	}
	
	
}
