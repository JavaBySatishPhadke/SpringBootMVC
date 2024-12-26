//DancerOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Dancer;

@Controller
public class DancerOperationsController {
	
	@GetMapping("/")  //form page launching
	public  String  showHomePage() {
		System.out.println("DancerOperationsController.showHomePage()");
		//return  LVN  (welcome page)
		return "welcome";
	}
	
	@GetMapping("/register")
	public    String    showDancerRegistrationFormPage(@ModelAttribute Dancer dcr) {
		System.out.println("DancerOperationsController.showDancerRegistrationPage():: Model class obj data::"+dcr);
		//return  LVN (form page)
		return  "dancer_register_form";
	}
	
	@PostMapping("/register")  // for  form page  submission
	public  String   registerDancer(@ModelAttribute Dancer  dcr,
			                                                  Map<String,Object> map) {
		System.out.println("DancerOperationsController.registerDancer()");
		System.out.println("Model class obj data ::"+dcr);
		//b.logic
		if(dcr.getFee()>10000)
			map.put("feeRange", "Costly Dancer");
		else if(dcr.getFee()<=0)
			map.put("feeRange", "Charity Dancer");
		else
			map.put("feeRange","Affordable Dancer");
		//return  LVN
		return "show_result";
	}

}
