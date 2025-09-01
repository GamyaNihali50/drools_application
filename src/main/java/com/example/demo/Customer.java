package com.example.demo;

import lombok.Builder;
import lombok.Data;

//Lombok's @Data generates getters, setters, and constructors at compile time using annotations
@Data
//@Builder provides a builder API for creating instances in a fluent and readable way.
@Builder
public class Customer {

	private String name;
	private String status;
	private int discount;

}
