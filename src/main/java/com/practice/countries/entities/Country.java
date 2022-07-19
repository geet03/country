package com.practice.countries.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int countryId;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "continent")
		private String continent;
		
		
		public Country() {}		

		public Country(String name, String continent) {			
			this.name = name;
			this.continent = continent;
		}

		public int getCountryId() {
			return countryId;
		}

		public void setCountryId(int countryId) {
			this.countryId = countryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContinent() {
			return continent;
		}

		public void setContinent(String continent) {
			this.continent = continent;
		}		
}
