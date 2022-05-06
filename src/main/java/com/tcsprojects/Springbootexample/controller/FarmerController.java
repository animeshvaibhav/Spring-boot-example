package com.tcsprojects.Springbootexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcsprojects.Springbootexample.entity.Farmer;
import com.tcsprojects.Springbootexample.error.FarmerNotFoundException;
import com.tcsprojects.Springbootexample.service.FarmerService;

@RestController
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	private final Logger LOGGER= 
			LoggerFactory.getLogger(FarmerController.class);
	
	@PostMapping("/farmers")
	public Farmer saveFarmer(@Valid @RequestBody Farmer farmer) {
		
		LOGGER.info("Inside saveFarmer of FarmerController...");
		return farmerService.saveFarmer(farmer);
	}
	@GetMapping("/farmers")
	public List<Farmer> fetchFarmerList(){
		LOGGER.info("Inside fetchFarmerList of FarmerController...");

		return farmerService.fetchFarmerList();
	}
	
	@GetMapping("/farmers/{id}")
	public Farmer fetchFarmerById(@PathVariable("id") Long FarmerId) throws FarmerNotFoundException {
		return farmerService.fetchFarmerById(FarmerId);
	}
	
	@DeleteMapping("/farmers/{id}")
	public String deleteFarmerById(@PathVariable("id") Long FarmerId) {
		farmerService.deleteFarmerById(FarmerId);
		return "Farmer deleted successfully!!!";
	}
	
	@PutMapping("/farmers/{id}")
	public Farmer updateFarmerById(@PathVariable("id") Long FarmerId,
			@RequestBody Farmer farmer) {
		return farmerService.updateFarmerById(FarmerId,farmer);
	}
	
	@GetMapping("/farmers/name/{name}")
	public Farmer fetchFarmerByName(@PathVariable("name") String name) {
		return farmerService.fetchFarmerByName(name);
	}
}
