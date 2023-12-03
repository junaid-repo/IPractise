package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jpa.entity.ClassEntity;

public interface SchoolRepository extends JpaRepository<ClassEntity, Integer>{

}
