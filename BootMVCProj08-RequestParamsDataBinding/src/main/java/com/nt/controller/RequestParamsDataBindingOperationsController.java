//RequestParamsDataBindingOperationsController.java
package com.nt.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class RequestParamsDataBindingOperationsController {
	
	/*@GetMapping("/data")
	public   String    processData(@RequestParam("sno") int no,
			                                               @RequestParam("sname") String name) {
		System.out.println("Request params::"+no+"      "+name);
		//return  LVN
		return  "show_result";
	}*/
	
	
	/*@GetMapping("/data")
	public   String    processData(@RequestParam int sno,
			                                               @RequestParam(required = false) String sname) {
		System.out.println("Request params::"+sno+"      "+sname);
		//return  LVN
		return  "show_result";
	}
	*/
	
	
	/*	@GetMapping("/data")
		public   String    processData(@RequestParam int sno,
				                                               @RequestParam(required = false,defaultValue = "Pushpa2-The Rule") String sname) {
			System.out.println("Request params::"+sno+"      "+sname);
			//return  LVN
			return  "show_result";
		}*/
	
	
	/*@GetMapping("/data")
	public   String    processData(@RequestParam(defaultValue ="3010") int sno,
			                                               @RequestParam String sname) {
		System.out.println("Request params::"+sno+"      "+sname);
		//return  LVN
		return  "show_result";
	}*/
	
	/*	@GetMapping("/data")
		public   String    processData(@RequestParam(required = false) Integer sno,
				                                               @RequestParam String sname) {
			System.out.println("Request params::"+sno+"      "+sname);
			//return  LVN
			return  "show_result";
		}*/
	
	
	/*@GetMapping("/data")
	public   String    processData(@RequestParam(required = false) Integer sno,
			                                               @RequestParam String sname,
			                                               @RequestParam  String sadd[],
			                                                @RequestParam("sadd") List<String> addrses,
			                                                @RequestParam("sadd") Set<String> location) {
		System.out.println("Request params::"+sno+"      "+sname+"    "+Arrays.toString(sadd)+"   "+addrses+"    "+location);
		//return  LVN
		return  "show_result";
	}
	*/
	
	/*@GetMapping("/data")
	public   String    processData(@RequestParam(required = false) Integer sno,
			                                               @RequestParam String sname,
			                                               @RequestParam  String sadd) {
			System.out.println("Request params::"+sno+"      "+sname+"    "+sadd);
		//return  LVN
		return  "show_result";
	}*/
	
	@Autowired
	private  ServletContext sc;
	@Autowired
	private   ServletConfig cg;
	
	/*@GetMapping("/data")
	public    String   processData(Map<String,Object> map,HttpServletRequest req, HttpServletResponse res,HttpSession ses)throws Exception{
		System.out.println("Web application's current name::"+sc.getContextPath());
		System.out.println("DispatcherServlet logical name:"+cg.getServletName());
		System.out.println("request path ::"+req.getServletPath());
		System.out.println("Session Id ::"+ses.getId());
		//keep the above data in  shared memory as the model  attibutes
		map.put("WAName", sc.getContextPath());
		map.put("DSL", cg.getServletName());
		map.put("path", req.getServletPath());
		map.put("sesId",ses.getId());
		
		return "show_data";
	}*/
	
	@GetMapping("/data")
	public    void   processData(Map<String,Object> map,HttpServletRequest req, HttpServletResponse res,HttpSession ses)throws Exception{
		// get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write  the output to browser
		pw.println("request Path:"+req.getServletPath());
	}
	
}
