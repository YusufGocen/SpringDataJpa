package com.YusufGocen.Controller;

import java.util.List;

import com.YusufGocen.Dto.DtoStudent;
import com.YusufGocen.Dto.DtoStudentIU;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent>GetAllStudent();
	
	public DtoStudent GetStudentById(Integer id);
	
	public void deleteStudent (Integer id);


}

