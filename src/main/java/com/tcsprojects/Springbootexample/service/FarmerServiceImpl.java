package com.tcsprojects.Springbootexample.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcsprojects.Springbootexample.entity.Farmer;
import com.tcsprojects.Springbootexample.error.FarmerNotFoundException;
import com.tcsprojects.Springbootexample.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	private FarmerRepository farmerRepository;
	@Override
	public Farmer saveFarmer(Farmer farmer) {
		
		return farmerRepository.save(farmer);
	}
	@Override
	public List<Farmer> fetchFarmerList() {
		
		return farmerRepository.findAll();	
	}
	@Override
	public Farmer fetchFarmerById(Long FarmerId) throws FarmerNotFoundException {

		Optional<Farmer> farmer= farmerRepository.findById(FarmerId);
		if(!farmer.isPresent()) {
			throw new FarmerNotFoundException("Farmer Not Available...");
		}
		return farmerRepository.findById(FarmerId).get();
	}
	@Override
	public void deleteFarmerById(Long farmerId) {
		
		farmerRepository.deleteById(farmerId);
		
	}
	@Override
	public Farmer updateFarmerById(Long farmerId, Farmer farmer) {
		Farmer temp=farmerRepository.findById(farmerId).get();
		if(Objects.nonNull(farmer.getName()) &&
				!"".equalsIgnoreCase(farmer.getName())) {
			temp.setName(farmer.getName());
		}
		if(Objects.nonNull(farmer.getLandArea())) {
			temp.setLandArea(farmer.getLandArea());
		}
		if(Objects.nonNull(farmer.getBudget())) {
			temp.setBudget(farmer.getBudget());
		}
		if(Objects.nonNull(farmer.getMoneyRaised())) {
			temp.setMoneyRaised(farmer.getMoneyRaised());
		}
		
		return farmerRepository.save(temp);
	}
	@Override
	public Farmer fetchFarmerByName(String name) {
		
		return farmerRepository.findByNameIgnoreCase(name);
	}
	
	

	
}
