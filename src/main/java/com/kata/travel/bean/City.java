package com.kata.travel.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class City implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7863418404356297019L;
	private String city;
	private String country;
	private List<String> attractions;
	private String visited;
	
	/**
	 * @return the city
	 */
	@JsonGetter("City")
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	@JsonSetter("City")
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	@JsonGetter("Country")
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	@JsonSetter("Country")
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the attractions
	 */
	@JsonGetter("Attractions")
	public List<String> getAttractions() {
		return attractions;
	}
	/**
	 * @param attractions the attractions to set
	 */
	@JsonSetter("Attractions")
	public void setAttractions(List<String> attractions) {
		this.attractions = attractions;
	}

	/**
	 * @return the visited
	 */
	@JsonGetter("Visited")
	public String getVisited() {
		if(visited==null)
			return "NO";
		return visited;
	}
	/**
	 * @param visited the visited to set
	 */
	@JsonSetter("Visited")
	public void setVisited(String visited) {
		this.visited = visited;
	}
	
	
	public City() {

	}
	public City(String city, String country, List<String> attractions,String visited) {
	    this.city = city;
		this.country = country;
		this.attractions = attractions;
		if(visited==null||"null".equals(visited))
			this.visited="N";
		else
			this.visited=visited;
	}
	public City(String city, String country, List<String> attractions) {
	        this.city = city;
		this.country = country;
		this.attractions = attractions;
	}
	public City(String city, String country) {
	    this.city = city;
		this.country = country;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryDestination [city=" + city + ", country=" + country + ", attractions=" + attractions
				+ ", visited=" + visited + "]";
	}





}
