package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@Controller
public class SeasonFinderOperationsController {
	@Autowired
	private   ISeasonFinderService  service;
	
	
	@RequestMapping("/")
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

}
