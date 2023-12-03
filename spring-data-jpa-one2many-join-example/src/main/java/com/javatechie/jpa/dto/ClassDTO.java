package com.javatechie.jpa.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.javatechie.jpa.entity.Teacher;

import lombok.Data;

@Data
public class ClassDTO {
	private Integer std;

	private String section;

	private Integer strength;
	private Integer boys;
	private Integer girls;
	private String classTeacher;
	private List<Teacher> teachers;

}
