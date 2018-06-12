package com.cis365.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis365.rest.Starship;
import com.cis365.rest.dao.StarshipDAO;

@RestController
@RequestMapping(value="/")
public class StarshipController {


	@Autowired
	StarshipDAO shipDAO;
	
	
	
	//get all ships
	@GetMapping("/starship")
	public List<Starship> getAllStarship(){
		return shipDAO.findAll();
	}
	
	//create new one
	@PostMapping("/starship")
	public Starship createNewPlanet(@Valid @RequestBody Starship starship) {
		return shipDAO.save(starship);
	}
	
	//get a ship by id
	@GetMapping("/starship/{id}")
	public  ResponseEntity<Starship> getPlanetById(@PathVariable(value="id") Long pid){
		Starship starship=shipDAO.findOne(pid);
		if(starship==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(starship);
		
	}
	
	//update an planet by id
	@PutMapping("/Starship/{id}")
	public ResponseEntity<Starship> updatePlanet(@PathVariable(value="id") Long pid,@Valid @RequestBody Starship starshipsetail){
		
		Starship starship=shipDAO.findOne(pid);
		if(starship==null) {
			return ResponseEntity.notFound().build();
		}
		
		starship.setName(starshipsetail.getName());
		starship.setCrewsize(starshipsetail.getCrewsize());
		starship.setLaunchstardate(starshipsetail.getLaunchstardate());
		starship.setShipclass(starship.getShipclass());
		Starship updateship=shipDAO.save(starship);
		return ResponseEntity.ok().body(updateship);
		
		
		
	}
	
	//Delete a planet
	@DeleteMapping("/starship/{id}")
	public ResponseEntity<Starship> deletePlanet(@PathVariable(value="id") Long pid){
		
		Starship ship=shipDAO.findOne(pid);
		if(ship==null) {
			return ResponseEntity.notFound().build();
		}
		shipDAO.delete(ship);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
