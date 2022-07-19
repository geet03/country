package com.practice.countries.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.countries.jpa.CountryRepository;
import com.practice.countries.model.Country;

@Component
public class CountryService {
	
	@Autowired
	private CountryRepository repo;
		
	public List<Country> loadAllCountries(){
		List<com.practice.countries.entities.Country> countries = this.repo.findAll();
		return countries.stream().map(country->{
			Country cnty = new Country(country.getCountryId(), country.getName(), country.getContinent());
			return cnty;
		}).collect(Collectors.toList());
	}

	public Country addCountry(Country country) {
		com.practice.countries.entities.Country countryEntity = new com.practice.countries.entities.Country(country.getName(), country.getContinent());
		com.practice.countries.entities.Country response = this.repo.save(countryEntity);	
		return new Country(response.getCountryId(), response.getName(), response.getContinent());
	}

	public Country updateCountry(int id, Country country) {
		com.practice.countries.entities.Country countryEntity = this.repo.findById(id).orElse(null);
		if(countryEntity == null) {
			return null;
		}
		countryEntity.setName(country.getName());
		countryEntity.setContinent(country.getContinent());
		com.practice.countries.entities.Country response = this.repo.save(countryEntity);
		return new Country(response.getCountryId(), response.getName(), response.getContinent());
	}

	public boolean removeCountry(int id) {
		this.repo.deleteById(id);
		return true;
	}

	public Country loadCountry(int id) {
		com.practice.countries.entities.Country response = this.repo.findById(id).orElse(null);
		if(response == null) {
			return null;
		}
		return new Country(response.getCountryId(), response.getName(), response.getContinent());
	}	
}
