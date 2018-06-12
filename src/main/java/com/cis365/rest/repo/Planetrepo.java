package com.cis365.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cis365.rest.Planet;

public interface Planetrepo extends JpaRepository<Planet, Long> {

}
