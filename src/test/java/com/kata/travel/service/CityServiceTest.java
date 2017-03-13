package com.kata.travel.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kata.travel.bean.City;

public class CityServiceTest {
	
	private List<City> generateMockList()
	{		
		List<City> listCity = new ArrayList<City>(
		Arrays.asList(new City("Manchester","UK",Arrays.asList("football", "bars")),
				new City("Liverpool","UK",Arrays.asList("football", "bars", "music")),
				new City("York","UK",Arrays.asList("city walls", "cathedral")),
				new City("Las Vegas","USA",Arrays.asList("casinos","Grand Canyon","shows")),
				new City("Beijing","China",Arrays.asList("Great Wall of China", "Forbidden City"))));
		return listCity;
	}
	
	@Test
	public void checkAddElement()
	{
		CityService service = new CityService(generateMockList() );		
		int initCount = service.getCityList().size();
		
		// Try to add new city
		
		service.addCity(new City("Paris","FR", Arrays.asList("Eiffel Tower")));
		
		int currentCount=service.getCityList().size();
		assertEquals(initCount+1,currentCount);
		City addCity=service.getCityList().get(currentCount-1);
		assertEquals("Paris",addCity.getCity());
		assertEquals("FR",addCity.getCountry());
		assertEquals(Arrays.asList("Eiffel Tower"),addCity.getAttractions());
		
		//Try to add existing city 
		
		service.addCity(new City("Paris","FR", Arrays.asList("Eiffel Tower")));
		
		currentCount=service.getCityList().size();
		assertEquals(initCount+1,currentCount);
		addCity = service.getCityList().get(currentCount-1);
		assertEquals("Paris",addCity.getCity());
		assertEquals("FR",addCity.getCountry());
		assertEquals(Arrays.asList("Eiffel Tower"),addCity.getAttractions());		
	}
	
	@Test
	public void checkUpdateElement()
	{
		CityService service = new CityService(generateMockList());		
		int initCount = service.getCityList().size();
		
		// Try to update Visit flag by NO
		service.updateCity(new City("Beijing","China", Arrays.asList("Great Wall of China", "Forbidden City"),"NO"));
		int currentCount=service.getCityList().size();
		assert(currentCount==initCount);
		City addCity=service.getCityList().get(initCount-1);
		assertEquals("Beijing",addCity.getCity());
		assertEquals("China",addCity.getCountry());
		assertEquals(Arrays.asList("Great Wall of China", "Forbidden City"),addCity.getAttractions());
		assertEquals("NO",addCity.getVisited());	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkUpdateNonExistingElement()
	{
		CityService service = new CityService(generateMockList());
		service.updateCity(new City("Paris","FR", Arrays.asList("Eiffel Tower"),"NO"));
	}

}
