package com.kata.travel.rest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kata.travel.ConfigData;
import com.kata.travel.bean.City;
import com.kata.travel.service.CityService;
@Path("/city")  
public class CityController {  
   
 CityService cityService=new CityService(ConfigData.getInstance().getCityList());  
   
    @GET  
    @Produces(MediaType.APPLICATION_JSON)  
 public List<City> getCityList()  
 {  
    	return cityService.getCityList();   
 }  

    @POST  
    @Produces(MediaType.APPLICATION_JSON)  
 public City addCity(City city)  
 {      	
    	boolean done = cityService.addCity(city);
    	if( done)
    		return  city;
    	else
    		return null;    	
 } 
    
    @PUT  
    @Produces(MediaType.APPLICATION_JSON)  
 public City updateCity(City city)  
 {  
    	return cityService.updateCity(city);  
    
 } 
}
