package com.YusufGocen.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YusufGocen.Dto.DtoDepartment;
import com.YusufGocen.Dto.DtoEmployee;
import com.YusufGocen.Repository.EmployeeRepository;
import com.YusufGocen.entites.Employee;
import com.YusufGocen.services.IEmployeeService;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployee() {
		List<Employee>employeeList= employeeRepository.findAll();
		
		List<DtoEmployee>dtoEmployeeList=new ArrayList<>();
		
		if (!employeeList.isEmpty() && employeeList!=null) {
			for (Employee employee : employeeList) {
				DtoEmployee dtoEmployee=new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId()
															,employee.getDepartment().getDepartmentName()));
				
				dtoEmployeeList.add(dtoEmployee);
			}
		}
		return dtoEmployeeList;
	}

	
	
}
