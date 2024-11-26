package com.YusufGocen.services;

import java.util.List;

import com.YusufGocen.Dto.DtoStudent;
import com.YusufGocen.Dto.DtoStudentIU;

public interface IStudentServices {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent>GetAllStudent();

	public DtoStudent GetStudentById(Integer id);
	
	public void deleteStudent(Integer id);
}
