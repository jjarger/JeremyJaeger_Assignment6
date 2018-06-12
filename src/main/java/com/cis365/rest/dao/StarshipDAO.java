package com.cis365.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cis365.rest.Starship;
import com.cis365.rest.repo.StarshipRepo;;

@Service
public class StarshipDAO {
	@Autowired
	StarshipRepo starShipRepo;
	
	//save planets
	public Starship save(Starship starship) {
		return starShipRepo.save(starship);
	}

	//find all starship
	public List<Starship> findAll() {
		return starShipRepo.findAll();
	}
	
	//find one starship
	public Starship findOne(Long shipid) {
		return starShipRepo.findOne(shipid);
	}
	
	//delete starship 
	
	public void delete(Starship ship) {
		starShipRepo.delete(ship);
	}

}
