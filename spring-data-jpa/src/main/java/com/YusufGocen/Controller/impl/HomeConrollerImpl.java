package com.YusufGocen.Controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YusufGocen.Controller.IHomeController;
import com.YusufGocen.Dto.DtoHome;
import com.YusufGocen.services.IHomeService;

@RestController
@RequestMapping(path = "/rest/api/home")
public class HomeConrollerImpl implements IHomeController{

	@Autowired
	private IHomeService homeService;
	
	@GetMapping(path = "/{id}")
	@Override
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		return homeService.findHomeById(id);
	}

	
}
