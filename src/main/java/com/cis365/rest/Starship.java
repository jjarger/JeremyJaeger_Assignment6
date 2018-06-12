package com.cis365.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Starship")
public class Starship {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long starshipid;

	@NotBlank
	private String name;
	@NotBlank
	private int crewsize;
	@NotBlank
	private String shipclass;
	
	@NotBlank
	private int launchstardate;

	public long getStarshipid() {
		return starshipid;
	}

	public void setStarshipid(long starshipid) {
		this.starshipid = starshipid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCrewsize() {
		return crewsize;
	}

	public void setCrewsize(int crewsize) {
		this.crewsize = crewsize;
	}

	public String getShipclass() {
		return shipclass;
	}

	public void setShipclass(String shipclass) {
		this.shipclass = shipclass;
	}

	public int getLaunchstardate() {
		return launchstardate;
	}

	public void setLaunchstardate(int launchstardate) {
		this.launchstardate = launchstardate;
	}
	
	
	

	
}
