package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService  empService;
	
	@GetMapping("/")
	public  String  showHomePage() {
		return  "welcome";
	}
	
	
	
	@PostMapping("/search")
	public  String    showReportWithDyamicSearch(@ModelAttribute("emp") Employee emp,
			                                                                                   Map<String,Object> map) {
		//use  service
		List<Employee> list=empService.showEmployeeReportWithDynamicSearch(emp);
		//keep result in shared memory as the flash attribute
		map.put("empsList", list);
		// return LVN
		return  "show_report";
	}
	
	
	
	@GetMapping("/report")   //  GET mode handler method  (G)
	public  String   showReport(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
		try {
		//use service
		List<Employee> list=empService.showAllEmployees();
		// keep the results in shared Memory
		map.put("empsList", list);
		//return LVN
		return  "show_report";
		}
		catch(Exception  e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}
		
	}
	
	@GetMapping("/register")  //form launching for addEmployee operation
	public  String  showEmployeeRegistrationPage(@ModelAttribute("emp") Employee emp) {
		//return  form page LVN
		return  "employee_register";
		
	}
	
	
	/*	@PostMapping("/register")   ////form Submission for addEmployee operation   (POST -P)
		public  String    registerEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
			try {
				String msg=empService.registerEmployee(emp);
				map.put("resultMsg", msg);
				return "redirect:report";    //Redirection - R
			}
			catch(Exception e) {
				e.printStackTrace();
				map.put("errorMsg", e.getMessage());
				return "error";
			}
	
		}
	*/
	
	/*@PostMapping("/register")   ////form Submission for addEmployee operation   (POST -P)
	public  String    registerEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		try {
			String msg=empService.registerEmployee(emp);
		    attrs.addFlashAttribute("resultMsg", msg);  //redirection scope attribute
			return "redirect:report";    //Redirection - R
		}
		catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());  //request  scope attribute
			return "error";
		}
	
	}*/
	
	@PostMapping("/register")   ////form Submission for addEmployee operation   (POST -P)
	public  String    registerEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		try {
			String msg=empService.registerEmployee(emp);
		    ses.setAttribute("resultMsg", msg);  //redirection scope attribute
			return "redirect:report";    //Redirection - R
		}
		catch(Exception e) {
			e.printStackTrace();
			ses.setAttribute("errorMsg", e.getMessage());  //request  scope attribute
			return "error";
		}
	
	}

	
	/*	@PostMapping("/register")   ////form Submission for addEmployee operation ,raises   Double Posting problem
		public  String    registerEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
			try {
				//use service
				String msg=empService.registerEmployee(emp);
				List<Employee> list=empService.showAllEmployees();
				
				map.put("resultMsg", msg);
				map.put("empsList",list);
				//return  LVN
				return "show_report";
			}
			catch(Exception e) {
				e.printStackTrace();
				map.put("errorMsg", e.getMessage());
				return "error";
			}
			
		}*/
	
	
	@GetMapping("/edit")
	   public  String   showEditFormPage(@RequestParam("no") int  no,
			                                                           @ModelAttribute("emp") Employee emp) {
		//use service
		 Employee emp1=empService.fetchEmployeeById(no);
		 //copy  emp1 object data to emp object
		 BeanUtils.copyProperties(emp1, emp);
		 //return  LVN
		 return  "employee_edit";
		   
	   }
	
	@PostMapping("/edit")
	public  String     updateEmployeeDetails(@ModelAttribute("emp") Employee emp,
			                                                                     RedirectAttributes  attrs) {
		try {
		//use  service
		String msg=empService.editEmployee(emp);
		//keep  the result model atribute
	   attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
		}
		catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/delete")
	public   String    removeEmployee(@RequestParam("no") int no,
			                                                        Map<String,Object> map) {
		try {
		//use seruvce
		String  msg=empService.deleteEmployeeById(no);
		//keep result in model attribute
		map.put("resultMsg", msg);
		//return LVN
		return  "forward:report";
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}
		
	}

}
