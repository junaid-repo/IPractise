package com.javatechie.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.jpa.dto.ClassDTO;
import com.javatechie.jpa.entity.ClassEntity;
import com.javatechie.jpa.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepo;

	public String saveTeacher(ClassDTO request) {

		System.out.println("Entered in saveTeacher method with Id---> " + request.getStd());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClassEntity req = new ClassEntity();
		req.setStd(request.getStd());
		req.setBoys(request.getBoys());
		req.setClassTeacher(request.getClassTeacher());
		req.setSection(request.getSection());
		req.setStrength(request.getStrength());
		req.setGirls(request.getGirls());
		req.setTeachers(request.getTeachers());
		schoolRepo.save(req);

		return "success";
	}

	public ClassEntity getClassDetails(Integer std) {
		return schoolRepo.findById(std).get();
	}

}
