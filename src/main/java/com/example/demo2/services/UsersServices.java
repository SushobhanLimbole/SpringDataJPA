package com.example.demo2.services;

import java.util.List;

import com.example.demo2.models.Users;
import com.example.demo2.projections.UserNameOnly;
import com.example.demo2.projections.UsersDTO;

public interface UsersServices {

	void addUser(Users user);
	void addMultipleUsers(List<Users> users);
	List<Users> getUsers();
	Users getUserById(int id);
	Users getUserByName(String name);
	List<Users> getUsersByAge(int age);
	List<Users> getUsersByAgeAndCity(int age, String city);
	List<Users> getUsersByNameOrCity(String name, String city);
	List<Users> getUsersByAgeGreaterThanOrEquals(int age);
	List<Users> getUsersByAgeLessThan(int age);
	List<Users> getUsersByAgeBetween(int start, int age);
	List<Users> getUsersByUserNameLike(String patt);
	List<Users> getUsersByUserNameEndingWith(String patt);
	List<Users> getUsersInDescOrderOfAge(int age);
	List<Users> getUsersByName(String name);
	List<Users> getUsersByNativeQuery(String name);
	int deleteUsersUsingJPQL(String name);
	int updateUserNative(String name, String updatedName);
	List<UserNameOnly> getOnlyNames(String city);
	List<UsersDTO> getOnlyNamesAndAge(String city);
	List<Users> getPagedUsers(int age, int pageNumber, int pageSize);
	List<Users> customMethod(int age);
}
