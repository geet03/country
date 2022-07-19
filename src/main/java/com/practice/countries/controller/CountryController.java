package com.practice.countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.countries.model.Country;
import com.practice.countries.service.CountryService;

@RestController
@RequestMapping("api/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public List<Country> loadAllCountries() {
		return this.countryService.loadAllCountries();
	}

	@GetMapping("/{id}")
	public Country loadCountry(@PathVariable("id") int id) {
		return this.countryService.loadCountry(id);
	}

	@PostMapping
	public Country addCountry(@RequestBody Country country) {
		return this.countryService.addCountry(country);
	}

	@PutMapping("/{id}")
	public Country updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
		return this.countryService.updateCountry(id, country);
	}

	@DeleteMapping("/{id}")
	public boolean removeCountry(@PathVariable("id") int id) {
		return this.countryService.removeCountry(id);
	}
}
