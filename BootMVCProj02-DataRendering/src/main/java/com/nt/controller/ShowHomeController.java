package com.nt.controller;


import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowHomeController {
	
	/*@RequestMapping("/home")
	public  String   dispalyHomePage() {
		//return LVN
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public  String   dispalyHomePage(Map<String,Object> map) {
		System.out.println("Shared Memory name ::"+map.getClass());
		// add  data/results to  shared Memory as the model attribute having name-value pairs
		map.put("sysDate", new Date());
		map.put("age", new Random().nextInt(100));
		//return LVN
		return "welcome";
	}*/
	
	/*	@RequestMapping("/")
		public  String   dispalyHomePage(Model model) {
			System.out.println("Shared Memory name ::"+model.getClass());
			// add  data/results to  shared Memory as the model attribute having name-value pairs
			model.addAttribute("sysDate", new Date());
		   model.addAttribute("age", new Random().nextInt(100));
			//return LVN
			return "welcome";
		}
	*/
	
	/*@RequestMapping("/")
	public  String   dispalyHomePage(ModelMap map) {
		System.out.println("Shared Memory name ::"+map.getClass());
		// add  data/results to  shared Memory as the model attribute having name-value pairs
		map.addAttribute("sysDate", new Date());
	   map.addAttribute("age", new Random().nextInt(100));
		//return LVN
		return "welcome";
	}*/
	
	/*	@RequestMapping("/home")
		public  Model  dispalyHomePage() {
			//create the shared Memory
			Model model=new BindingAwareModelMap();
			// add  data/results to  shared Memory as the model attribute having name-value pairs
			model.addAttribute("sysDate", new Date());
		   model.addAttribute("age", new Random().nextInt(100));
			//return LVN
			return model;
		}*/
	
	/*	@RequestMapping("/home")
		public  Map<String,Object>  dispalyHomePage() {
			//create the shared Memory
			   Map<String,Object> map=new HashMap<>();
			// add  data/results to  shared Memory as the model attribute having name-value pairs
			map.put("sysDate", new Date());
		    map.put("age", new Random().nextInt(100));
			//return LVN
			return map;
		}*/
	
	/*@RequestMapping("/home")
	public  ModelAndView  dispalyHomePage() {
		//create the shared Memory
		   ModelAndView mav=new ModelAndView();
		   // add  data/results to  shared Memory as the model attribute having name-value pairs
	      mav.addObject("sysDate", new Date());
	     mav.addObject("age", new Random().nextInt(100));
	       //set LVN to  MAV object
	     mav.setViewName("welcome");
		//return MAV object
		return mav;
	}*/
	
	
	/*	@RequestMapping("/home")
	public  void  dispalyHomePage(Map<String,Object> map) {
		// add  data/results to  shared Memory as the model attribute having name-value pairs
		map.put("sysDate", new Date());
	    map.put("age", new Random().nextInt(100));
	
	}*/
	
	@RequestMapping("/home")
	public  String  dispalyHomePage(Map<String,Object> map) {
		System.out.println("ShowHomeController.dispalyHomePage()");
		// add  data/results to  shared Memory as the model attribute having name-value pairs
		map.put("sysDate", new Date());
	    map.put("age", new Random().nextInt(100));
	    return   "redirect:report?p1=val1&p2=val2";
	}
	
	@RequestMapping("/report")
	public    String  showReport(Map<String,Object> map) {
		System.out.println("ShowHomeController.showReport()");
		map.put("sysTime",LocalTime.now());
		return "show_report";
	}

	
	
}
