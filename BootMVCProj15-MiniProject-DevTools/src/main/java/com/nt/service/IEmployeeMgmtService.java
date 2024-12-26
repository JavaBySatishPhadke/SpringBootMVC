package com.nt.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
       public   Page<Employee>  showEmployeesByPagination(Pageable pageable);
       public   String   registerEmployee(Employee emp);
       public   Employee  fetchEmployeeById(int  id);
       public    String      editEmployee(Employee emp);
       public   String      deleteEmployeeById(int id);
}
