package com.nt.controller;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Student;

@Controller
public class DataRenderingOperationsController {
	
	@GetMapping("/data")
	public String   showData(Map<String,Object> map) {
		/*	//add model attributes (simple values)
			map.put("name", "raja");
			map.put("age", 30);*/
		 //add Model attriubues  (arrays and collections)
			/*	  map.put("favColors",new String[] {"red","maroon","cyan"});
				  map.put("friends", List.of("raja","rani","ramesh","suresh"));
				  map.put("phoneNumbers", Set.of(99999999L,88888888L,77777777L));
				  map.put("idDetails",Map.of("aadhar",899988,"voterId",8897777,"panNo",8877777) );*/
		
			/*	//  add Model  Attributes (Model class object)
				Student  st=new Student(1001, "raja", "hyd", 90.0f);
				map.put("studDetails", st);
			*/	
	//  add Model  Attributes (Colletion of Model class objects)
		Student  st1=new Student(1001, "raja", "hyd", 90.0f);
		Student  st2=new Student(1002, "mahesh", "delhi", 91.0f);
		Student  st3=new Student(1002, "mahesh", "delhi", 92.0f);
		List<Student>  list=List.of(st1,st2,st3);
		map.put("studList", list);
		//return LVN
		return "show_data";
		
	}
	
}
