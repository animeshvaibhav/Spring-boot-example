package com.tcsprojects.Springbootexample.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tcsprojects.Springbootexample.entity.Farmer;

@SpringBootTest
class FarmerServiceTest {

	@Autowired
	private FarmerService farmerService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void whenValidName_thenFarmerShouldFound() {
		String farmerName="Kishan Singh";
		Farmer found=farmerService.fetchFarmerByName(farmerName);
		assertEquals(farmerName,found.getName());
	}
}
