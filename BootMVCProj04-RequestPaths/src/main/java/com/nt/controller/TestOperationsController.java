package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tester")  //Controller class level global path
public class TestOperationsController {

	@GetMapping("/report")
	public   String  showReport() {
		System.out.println("TestOperationsController.showReport()");
		return "display_report2";
	}
}
