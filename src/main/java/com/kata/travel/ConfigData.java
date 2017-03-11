package com.kata.travel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.travel.bean.City;

public class ConfigData {


	private static ConfigData instance;
	private static List<City> cityList;

	public static synchronized ConfigData getInstance()
	{
		if (instance == null)
		{
			instance = new ConfigData();
		}
		return instance;
	}


	private ConfigData()
	{
		//read json file data to String
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("cities.conf").getFile());

			byte[] jsonData = Files.readAllBytes(file.toPath());
			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			cityList = objectMapper.readValue(jsonData,new TypeReference<List<City>>(){});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public List<City> getCityList() {
		return cityList;
	}
}
