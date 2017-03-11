package com.kata.travel.service;

import java.util.List;

import com.kata.travel.ConfigData;
import com.kata.travel.bean.City;


public class CityService {


	public CityService() {
		super();
	}

	public List<City> getCityList()
	{
		return ConfigData.getInstance().getCityList();
	}

	public boolean addCity(City city)
	{
		// Basic validation would be to check if the city exists in the city collection
		// If no then add a new item to the list , otherwise return an error message
		List<City> listOfCity = ConfigData.getInstance().getCityList();

		if(listOfCity.contains(city))
			return false;
		else
			listOfCity.add(city); 
		return true;
	}

	public City updateCity(City city) {

		List<City> listOfCity = ConfigData.getInstance().getCityList();
		if(listOfCity.contains(city))
		{
			City originalCity = listOfCity.get(listOfCity.indexOf(city));
			originalCity.setVisited(city.getVisited());
		}
	
		return city;
	}

}


