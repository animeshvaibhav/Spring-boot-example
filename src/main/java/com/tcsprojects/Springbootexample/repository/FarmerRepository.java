package com.tcsprojects.Springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcsprojects.Springbootexample.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Long>{

	public Farmer findByName(String name);
	public Farmer findByNameIgnoreCase(String name);
}
