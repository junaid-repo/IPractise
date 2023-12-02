package com.javatechie.executor.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.executor.api.entity.User;
import com.javatechie.executor.api.repository.UserRepository;

@Service
public class SimpleUserService {

	@Autowired
	UserRepository userRepo;

	public String saveUsers(List<User> usersList) {

		long st = System.currentTimeMillis();
		usersList.stream().forEach(obj -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userRepo.save(obj);
		});

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The value of i in simple --> " + i);
		}
		long et = System.currentTimeMillis();
		System.out.println("time taken in simple is --> " + (et - st));

		return "created";
	}

}
