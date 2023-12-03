package com.javatechie.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Classs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Integer std;
	private String section;
	private Integer strength;
	private Integer boys;
	private Integer girls;

	private String classTeacher;

	@OneToMany(targetEntity = Teacher.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk", referencedColumnName = "id")
	private List<Teacher> teachers;
}
