package com.travel.Agent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.Agent.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	

}
