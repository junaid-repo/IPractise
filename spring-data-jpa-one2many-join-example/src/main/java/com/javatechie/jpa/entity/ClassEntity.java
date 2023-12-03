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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {
	@Id
	private Integer std;

	private String section;

	private Integer strength;
	private Integer boys;
	private Integer girls;
	private String classTeacher;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Teacher.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ce_id", referencedColumnName = "std")
	private List<Teacher> teachers;
}
