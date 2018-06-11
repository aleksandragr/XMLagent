package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	Room findByIdEquals(Long id);
	
}
