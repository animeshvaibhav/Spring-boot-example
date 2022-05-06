package com.tcsprojects.Springbootexample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farmer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotBlank(message="Please add farmer name...")
	private String name;
	private double landArea;
	private double budget;
	private double moneyRaised;
	
	
}
