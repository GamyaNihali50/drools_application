package com.example.demo;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsDemo {

	    public static void main(String[] args) {
	       
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter Customer Name: ");
	    	String name = scanner.nextLine();
	    	System.out.print("Enter Customer Status: ");
	    	String status = scanner.nextLine();
	    	
	    	 // Initialize KIE services and container
	        KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();

	        // Create a session
	        KieSession kSession = kContainer.newKieSession("ksession-rules");
	        
	        // Create Customer object using Lombok's builder
	        Customer customer = Customer.builder()
	                .name(name)
	                .status(status)
	                .discount(0)
	                .build();	        		
	        		
	        // Insert the fact into Drools session
	        kSession.insert(customer);

	        // Fire all rules
	        kSession.fireAllRules();

	        // Check the discount applied
	        System.out.println("Final discount: " + customer.getDiscount());

	        // Clean up
	        kSession.dispose();
	    }
	   
	}

