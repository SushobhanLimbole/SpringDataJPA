package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo2.models.Users;
import com.example.demo2.projections.UserNameOnly;
import com.example.demo2.projections.UsersDTO;
import com.example.demo2.repositories.UsersRepo;

@Service
public class UsersServicesImpl implements UsersServices {

	@Autowired
	UsersRepo usersRepo;

	@Override
	public void addUser(Users user) {
		
		System.out.println("addUser called");
		try {
			usersRepo.save(user);
			System.out.println("user added successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void addMultipleUsers(List<Users> users) {
		
		try {
			System.out.println("addMultipleUsers called");
			usersRepo.saveAll(users);
			System.out.println("Users added successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public List<Users> getUsers() {
		try {
			System.out.println("getUsers called");
			return usersRepo.findAll();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public Users getUserById(int id) {
		try {
			System.out.println("getUserById called");
			Optional<Users> op = usersRepo.findById(id);
			Users user = op.get();
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public Users getUserByName(String name) {
		try {
			System.out.println("getUserByName called");
			return usersRepo.findByUserName(name);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByAge(int age) {
		try {
			System.out.println("getUsersByAge called");
			return usersRepo.findByAge(age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public List<Users> getUsersByAgeAndCity(int age, String city) {
		try {
			System.out.println("getUsersByAgeAndCity called");
			return usersRepo.findByAgeAndCity(age, city);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByNameOrCity(String name, String city) {
		try {
			System.out.println("getUsersByNameOrCity called");
			return usersRepo.findByUserNameOrCity(name, city);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByAgeGreaterThanOrEquals(int age) {
		try {
			System.out.println("getUsersByAgeGreaterThanOrEquals called");
			return usersRepo.findByAgeGreaterThanEqual(age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByAgeLessThan(int age) {
		try {
			System.out.println("getUsersByAgeLessThan called");
			return usersRepo.findByAgeLessThan(age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByAgeBetween(int start, int age) {
		try {
			System.out.println("getUsersByAgeBetween called");
			return usersRepo.findByAgeBetween(start, age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByUserNameLike(String patt) {
		try {
			System.out.println("getUsersByUserNameLike called");
			return usersRepo.findByUserNameLike(patt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByUserNameEndingWith(String patt) {
		try {
			System.out.println("getUsersByUserNameEndingWith called");
			return usersRepo.findByUserNameEndingWith(patt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersInDescOrderOfAge(int age) {
		try {
			System.out.println("getUsersByUserNameEndingWith called");
			return usersRepo.findByAgeGreaterThanOrderByAgeDesc(age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByName(String name) {
		try {
			System.out.println("getUsersByName called");
			return usersRepo.getByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getUsersByNativeQuery(String name) {
		try {
			System.out.println("getUsersByNativeQuery called");
			return usersRepo.getUsersNative(name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public int deleteUsersUsingJPQL(String name) {
		try {
			System.out.println("deleteUsersUsingJPQL called");
			return usersRepo.deleteUserJPQL(name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	@Override
	public int updateUserNative(String name, String updatedName) {
		try {
			System.out.println("updateUserNative called");
			return usersRepo.updateUserNative(name, updatedName);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	@Override
	public List<UserNameOnly> getOnlyNames(String city) {
		try {
			System.out.println("getOnlyNames called");
			return usersRepo.findByCity(city);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<UsersDTO> getOnlyNamesAndAge(String city) {
		try {
			System.out.println("getOnlyNamesAndAge called");
			return usersRepo.getByCity(city);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> getPagedUsers(int age, int pageNumber, int pageSize) {
		try {
			System.out.println("getPagedUsers called");
			/*
			 * Pageable is an interface and PageRequest is the class that implements its methods
			 * 
			 * ✅ What You Get in Page<T>
			 * When Spring returns a Page<User> object, it gives you:
			 * page.getContent();         // List<User>
			 * page.getTotalPages();      // total number of pages
			 * page.getTotalElements();   // total number of records
			 * page.getNumber();          // current page number (0-based)
			 * page.getSize();            // size of the page
			 * page.hasNext();            // true if next page exists
			 * page.hasPrevious();        // true if previous exists
			 * 
			 * 🧠 Slice vs Page
			 * Feature					Page		Slice
			 * Gives total count		✅ Yes		❌ No
			 * Lighter & faster			❌ No		✅ Yes
			 * Has getTotalPages()		✅ Yes		❌ No
			 * 
			 * Use Slice<User> if you only care about "next page" and want performance.
			 * 
			 * ✅ Summary
			 * Term					Use
			 * Pageable				Tell Spring which page/size/sort you want
			 * Page<T>				Holds the result + meta info
			 * PageRequest.of()		Factory method to create Pageable
			 * Sort.by()			Used for sorting fields
			 */
			
//			Unsorted
//			Pageable pageable = PageRequest.of(pageNumber, pageSize);
//			Page<Users> pages = usersRepo.readByAgeGreaterThanEqual(age, pageable);
//			return pages.getContent();
			
//			Sorted
			Sort desc = Sort.by("age").descending();
			Pageable pageable = PageRequest.of(pageNumber, pageSize, desc);
			Page<Users> pages = usersRepo.readByAgeGreaterThanEqual(age, pageable);
			return pages.getContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<Users> customMethod(int age) {
		try {
			System.out.println("customMethod called");
			return usersRepo.customLogicGetUsersByAge(age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
