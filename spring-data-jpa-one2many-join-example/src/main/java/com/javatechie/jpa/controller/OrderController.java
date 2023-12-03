package com.javatechie.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Classs;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.ClasssRepository;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClasssRepository classRepo;

	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}

	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}

	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation() {
		return customerRepository.getJoinInformation();
	}

	@PostMapping("/addClassDetails")
	public Classs addClassDetails(@RequestBody Classs request) {
		return classRepo.save(request);
	}

	@GetMapping("/getClassDetails/{std}")
	public Classs getClassDetails(@PathVariable Integer std) {

		return classRepo.findByStd(std);
	}
}
