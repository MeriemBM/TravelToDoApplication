package com.kata.travel.service;

import java.util.List;

import com.kata.travel.bean.City;


public class CityService {

	private List<City> listCity;
	
	public CityService(List<City> listCity) {
		this.listCity=listCity;		
	}

	public List<City> getCityList()
	{
		return listCity;
	}

	public boolean addCity(City city)
	{
		// Basic validation would be to check if the city exists in the city collection
		// If no then add a new item to the list , otherwise return an error message

		if(listCity.contains(city))
			return false;
		else
			listCity.add(city); 
		return true;
	}

	public City updateCity(City city) throws IllegalArgumentException {

		if(listCity.contains(city))
		{
			City originalCity = listCity.get(listCity.indexOf(city));
			originalCity.setVisited(city.getVisited());
			return city;
		}
	
		throw new IllegalArgumentException();
	}

}


