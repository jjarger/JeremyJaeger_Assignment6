package com.cis365.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cis365.rest.Planet;
import com.cis365.rest.repo.Planetrepo;

@Service
public class PlanetDAO {
	
	@Autowired
	Planetrepo planetRepo;
	
	//save planets
	public Planet save(Planet planet) {
		return planetRepo.save(planet);
	}

	//find all planets
	public List<Planet> findAll() {
		return planetRepo.findAll();
	}
	
	//find one planet
	public Planet findOne(Long planetid) {
		return planetRepo.findOne(planetid);
	}
	
	//delete planet
	
	public void delete(Planet planet) {
		planetRepo.delete(planet);
	}
}
