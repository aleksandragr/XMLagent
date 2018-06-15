package com.travel.Agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.Room;
import com.travel.Agent.services.RoomService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	
	
	@GetMapping("/roomsOfAcc/{id}")
	public ResponseEntity<List<Room>> getRoomsOfAcc(@PathVariable Long id){
		
		List<Room> rooms = roomService.getRoomsOfAccommodation(id);
		
		if(rooms!=null) {
			return new ResponseEntity<>(rooms,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
