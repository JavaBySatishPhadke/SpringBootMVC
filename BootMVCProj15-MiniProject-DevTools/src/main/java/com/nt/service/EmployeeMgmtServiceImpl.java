package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  IEmployeeRepository  empRepo;

	@Override
	public Page<Employee> showEmployeesByPagination(Pageable pageable) {
	                Page<Employee> page=empRepo.findAll(pageable);
	                return page;
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
			      return emp.getEmpno()+"  employee is updated/Edited";
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
	
}
