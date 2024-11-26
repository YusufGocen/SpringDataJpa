package com.YusufGocen.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YusufGocen.Dto.DtoCourse;
import com.YusufGocen.Dto.DtoStudent;
import com.YusufGocen.Dto.DtoStudentIU;
import com.YusufGocen.Repository.IStudentRepository;
import com.YusufGocen.entites.Course;
import com.YusufGocen.entites.student;
import com.YusufGocen.services.IStudentServices;

@Service
public class StudentServicesImpl implements IStudentServices {
	
	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtostudent) {
		DtoStudent response= new DtoStudent();
		student student=new student();
		BeanUtils.copyProperties(dtostudent, student);
		
		student dbStudent=studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response; 
	}

	@Override
	public List<DtoStudent> GetAllStudent() {
		List<DtoStudent>dtolist=new ArrayList<>();
		List<student>studentList=studentRepository.findAll();
		for (student student : studentList) {
			DtoStudent dto=new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtolist.add(dto);
		}
		return dtolist;
	}

	@Override
	public DtoStudent GetStudentById(Integer id) {
		DtoStudent dtoStudent=new DtoStudent();
		Optional<student>optinal= studentRepository.findById(id);
		if (optinal.isEmpty()) {
			return null;
			
		}
		student dbStudent=optinal.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if (dbStudent.getCourses()!=null && !dbStudent.getCourses().isEmpty()) {
			for (Course course : dbStudent.getCourses()) {
				DtoCourse dtoCourse=new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				dtoStudent.getCourses().add(dtoCourse);
			}
		}
		
		return dtoStudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		//DtoStudent dtoStudent=GetStudentById(id);
		Optional<student> optinal=studentRepository.findById(id);
		if(optinal.isPresent()) {
			studentRepository.delete(optinal.get());
		}
		
	}

}
