package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  IEmployeeRepository  empRepo;

	@Override
	public List<Employee> showAllEmployees() {
	    List<Employee>  list=StreamSupport.stream(empRepo.findAll().spliterator(), false).toList();
	   	    //return list.stream().sorted().toList();  //performs  natural sorting
	       return  list.stream().sorted((emp1,emp2)-> emp1.getEname().compareTo(emp2.getEname())).toList(); //sorting based on ename
	 	}

	@Override
	public String registerEmployee(Employee emp) {
		//use service
		 int idVal=empRepo.save(emp).getEmpno();
		return "Employee is registered with the id Value :"+idVal;
	}
	
	@Override
	public Employee fetchEmployeeById(int id) {
		return   empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));  
		
	}
	
	
	@Override
	public String editEmployee(Employee emp) {
		  Optional<Employee>  opt=empRepo.findById(emp.getEmpno());
		  if(opt.isPresent()) {
			      empRepo.save(emp);
			      return emp.getEmpno()+"  employee is updated";
		  }
		return emp.getEmpno()+"  employee is not found for updation";
	}
	
	@Override
	public String deleteEmployeeById(int id) {
		  Optional<Employee>  opt=empRepo.findById(id);
		  if(opt.isPresent()) {
			  empRepo.deleteById(id);
			  return id+"  Employee  is deleted";
		  }
		return id+" Employee is not found for deletion";
	}
	
	@Override
	public List<Employee> showEmployeeReportWithDynamicSearch(Employee emp) {
		// replace  empty Strings with null values
		 if(emp.getEname().equalsIgnoreCase("")|| emp.getEname().length()==0)
			 emp.setEname(null); 
		 if(emp.getJob().equalsIgnoreCase("")|| emp.getJob().length()==0)
			 emp.setJob(null); 
		 
		//prepare  Example obj having Employee object
		Example example=Example.of(emp);
		//use  repo
		List<Employee>  list=empRepo.findAll(example);
		return list;
	}
	
}
