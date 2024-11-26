package com.YusufGocen.Controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YusufGocen.Controller.IEmployeeController;
import com.YusufGocen.Dto.DtoEmployee;
import com.YusufGocen.services.IEmployeeService;

@RestController
@RequestMapping(path = "/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> findAllEmployee() {
		
		return 	employeeService.findAllEmployee(); 
	}

}
