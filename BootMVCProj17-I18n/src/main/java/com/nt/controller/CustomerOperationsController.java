package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	
	@GetMapping("/")
	public  String  showHome(Map<String,Object> map) {
		 map.put("sysDate", new Date());
		 map.put("salary", 23456787665.0);
		 map.put("avg",(56.0/100.0));
		
		return "welcome";
	}
	
	@GetMapping("/register")
	public  String  registerCustomer(@ModelAttribute("cust") Customer cust) {
		return  "customer_register";
		
	}

}
