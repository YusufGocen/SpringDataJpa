package com.YusufGocen.Dto;

import java.util.ArrayList;
import java.util.List;

import com.YusufGocen.entites.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
	
	private Integer id;
	
	private String isim;
	
	private List<DtoCourse>courses =new ArrayList<>();
}
