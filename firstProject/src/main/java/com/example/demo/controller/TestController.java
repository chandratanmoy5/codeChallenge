package com.example.demo.controller;

import java.util.*;
//import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dealer;

@RestController
public class TestController {
	
	ArrayList<Dealer> allDealers= new ArrayList<>();
	
	
	public TestController() {
		allDealers.add(new Dealer("Tanmoy","Kolkata",700008));
		
		allDealers.add(new Dealer("Sanu","Kolkata",700009));
		
		allDealers.add(new Dealer("Rakesh","Bihar",700012));
		
	}


	@RequestMapping("/dealers")
	public ArrayList<Dealer> dealers() {
		
		return allDealers;
		
	}
	
	@RequestMapping(value="/finddealer", method=RequestMethod.GET)
	public Dealer finddealer(@RequestParam Integer pincode) {
		
		System.out.println(pincode);
		
		ArrayList<Integer> diff= new ArrayList<>();
		for (Dealer dealer : allDealers) {
		    diff.add(java.lang.Math.abs(pincode-dealer.getPostalCode()));
		}
		return allDealers.get(diff.indexOf(Collections.min(diff)));
		
	}
	
	@RequestMapping(value="/adddealer", method=RequestMethod.POST)
	public ArrayList<Dealer> adddealer(@RequestBody Dealer newDealer) {
		
		allDealers.add(newDealer);
		System.out.println(newDealer);
		return allDealers;
		
	}
}
