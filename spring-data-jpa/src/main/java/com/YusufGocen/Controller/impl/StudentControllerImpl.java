package com.YusufGocen.Controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YusufGocen.Controller.IStudentController;
import com.YusufGocen.Dto.DtoStudent;
import com.YusufGocen.Dto.DtoStudentIU;
import com.YusufGocen.services.IStudentServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	@Autowired
	private IStudentServices studentServices;
	
	//Veri EKleme
	@PostMapping(path="/save")
	@Override
	public DtoStudent saveStudent(@RequestBody  DtoStudentIU dtoStudentIU) {
											//Hata Mesajları için @Valid Eklemen Lazım
		return studentServices.saveStudent(dtoStudentIU);
	}
	
	//Bütün Verileri Getirme
	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> GetAllStudent() {
		return studentServices.GetAllStudent();
	}
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent GetStudentById(@PathVariable(name = "id") Integer id) {
		
		return studentServices.GetStudentById(id);
	}
	
	//Verileri Silme
	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Integer id) 	{
		studentServices.deleteStudent(id);
	}

}
