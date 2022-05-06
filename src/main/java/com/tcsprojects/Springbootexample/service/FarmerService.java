package com.tcsprojects.Springbootexample.service;

import java.util.List;

import com.tcsprojects.Springbootexample.entity.Farmer;
import com.tcsprojects.Springbootexample.error.FarmerNotFoundException;

public interface FarmerService {

	

	public Farmer saveFarmer(Farmer farmer);

	public List<Farmer> fetchFarmerList();

	public Farmer fetchFarmerById(Long FarmerId) throws FarmerNotFoundException;

	public void deleteFarmerById(Long farmerId);

	public Farmer updateFarmerById(Long farmerId, Farmer farmer);

	public Farmer fetchFarmerByName(String name);

}
