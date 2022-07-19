package com.practice.countries.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	 
	public List<Country> findByName(String name);

	public List<Country> findAllByContinent(String continent);
}
