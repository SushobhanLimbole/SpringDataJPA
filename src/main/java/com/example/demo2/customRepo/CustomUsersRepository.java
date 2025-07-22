package com.example.demo2.customRepo;

import java.util.List;

import com.example.demo2.models.Users;

public interface CustomUsersRepository {
	List<Users> customLogicGetUsersByAge(int age);
}
