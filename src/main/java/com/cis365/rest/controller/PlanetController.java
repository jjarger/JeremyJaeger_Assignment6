package com.cis365.rest.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis365.rest.Planet;
import com.cis365.rest.dao.PlanetDAO;




@RestController
@RequestMapping(value="/")
public class PlanetController {
	
	@Autowired
	PlanetDAO planetDAO;
	
	
	
	//get all planet
	@GetMapping("/planet")
	public List<Planet> getAllPlanet(){
		return planetDAO.findAll();
	}
	
	//create new one
	@PostMapping("/planet")
	public Planet createNewPlanet(@Valid @RequestBody Planet planet) {
		return planetDAO.save(planet);
	}
	
	//get planet by id
	@GetMapping("/planet/{id}")
	public  ResponseEntity<Planet> getPlanetById(@PathVariable(value="id") Long pid){
		Planet planet=planetDAO.findOne(pid);
		if(planet==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(planet);
		
	}
	
	//update an planet by id
	@PutMapping("/planet/{id}")
	public ResponseEntity<Planet> updatePlanet(@PathVariable(value="id") Long pid,@Valid @RequestBody Planet planetDetail){
		
		Planet planet=planetDAO.findOne(pid);
		if(planet==null) {
			return ResponseEntity.notFound().build();
		}
		
		planet.setName(planetDetail.getName());
		planet.setRadius(planetDetail.getRadius());
		planet.setAtmosphere(planetDetail.getAtmosphere());
		
		Planet updatePlanet=planetDAO.save(planet);
		return ResponseEntity.ok().body(updatePlanet);
		
		
		
	}
	
	//Delete a planet
	@DeleteMapping("/planet/{id}")
	public ResponseEntity<Planet> deletePlanet(@PathVariable(value="id") Long pid){
		
		Planet planet=planetDAO.findOne(pid);
		if(planet==null) {
			return ResponseEntity.notFound().build();
		}
		planetDAO.delete(planet);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
