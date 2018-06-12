package com.cis365.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="planet")
public class Planet {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long planetid;

@NotBlank
private String name;
@NotBlank
private double radius;
@NotBlank
private String atmosphere;


public long getPlanetid() {
	return planetid;
}
public void setPlanetid(long planetid) {
	this.planetid = planetid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public String getAtmosphere() {
	return atmosphere;
}
public void setAtmosphere(String atmosphere) {
	this.atmosphere = atmosphere;
}




}
