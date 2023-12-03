package com.javatechie.executor.api.dto;

import java.util.List;

import com.javatechie.executor.api.entity.User;

import lombok.Data;

@Data
public class UsersList {
	List<User> usersList;
}
