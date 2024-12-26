package com.nt.interceptors;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeOutCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("TimeCheckInterceptor.preHandle()");
	   //get servlet path
		String path=req.getServletPath();
		// get  system date and time
		LocalDateTime  ldt=LocalDateTime.now();
        int  hour=ldt.getHour();
		
   if(path.equals("/")  || path.equals("/employee/home")) {
		  return true;	
     }
	    //write  the b.logic
	else    if(hour<9  ||  hour>17) {
	    	RequestDispatcher  rd=req.getRequestDispatcher("/timeout.jsp");
	    	rd.forward(req, res);
	    	return false;
	    }
	    return true;
	
	   	}

}
