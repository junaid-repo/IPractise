package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jpa.entity.Classs;

public interface ClasssRepository extends JpaRepository<Classs, Integer>{

	Classs findByStd(Integer std);

}
