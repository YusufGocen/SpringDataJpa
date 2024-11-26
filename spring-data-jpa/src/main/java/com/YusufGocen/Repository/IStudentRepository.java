package com.YusufGocen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YusufGocen.entites.student;

@Repository
public interface IStudentRepository extends JpaRepository<student, Integer>{

	
}
