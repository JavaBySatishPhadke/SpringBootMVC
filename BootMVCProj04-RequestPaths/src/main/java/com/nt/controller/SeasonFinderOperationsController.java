package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ISeasonFinderService;

@Controller
@RequestMapping("/season1")  //Controller class level global path
public class SeasonFinderOperationsController {
	@Autowired
	private   ISeasonFinderService  service;
	
	
	//@RequestMapping("/")
	@RequestMapping
	public  String  showHome() {
		return "welcome";
	}
	
	@RequestMapping("/season")
	public   String   showSeason(Map<String,Object> map) {
		//use service
		String result=service.findSeason();
		//keep the result in shared memory as the model attribute
		map.put("resultMsg", result);
		//return LVN
		return "display";
	}
	
	
	/*	@RequestMapping({"/report1","/report2","/report3"})
		public String  showReport1() {
			System.out.println("SeasonFinderOperationsController.showReport1()");
			return  "display_report1";
		}
	*/	
	/*	@RequestMapping("/REPORT")
		public    String  showReport2() {
			System.out.println("SeasonFinderOperationsController.showReport2()");
			return  "display_report2";
		}*/
	
	
	//@RequestMapping("/report")  //by default handler GET mode request  by defaukt
	//@RequestMapping(value="/report",method = RequestMethod.GET)
	@GetMapping("/report")
	public String  showReport1() {
		System.out.println("SeasonFinderOperationsController.showReport1()");
		return  "redirect:/tester/report";
	}
	
	/*//@RequestMapping(value="/report",method = RequestMethod.POST)  //by default handler POST mode request
	@PostMapping("/report")
	public String  showReport2() {
		System.out.println("SeasonFinderOperationsController.showReport2()");
		return  "display_report2";
	}
	*/

}
