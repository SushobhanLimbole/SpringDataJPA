package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo2.models.Users;
import com.example.demo2.projections.UserNameOnly;
import com.example.demo2.projections.UsersDTO;
import com.example.demo2.services.UsersServices;
import com.example.demo2.services.UsersServicesImpl;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {

		/*
		 * 🌱 What is Spring Data JPA? 
		 * Spring Data JPA is a part of the Spring Data
		 * project that simplifies database operations using Java Persistence API (JPA),
		 * typically with Hibernate under the hood.
		 * 
		 * It removes boilerplate code for writing queries and repositories and lets you
		 * focus on your business logic.
		 * 
		 * How to create a Spring Data JPA project?
		 * Go to web and search spring initialzr
		 * There enter project specifications
		 * Then enter project metadata :-
		 * Group Id : package name
		 * Artifact Id : project name
		 * Enter dependencies :-
		 * Spring Data JPA : It comes with Hibernate so no need to get that dependency explicitly.
		 * MySQL Driver : MySQL JDBC Driver for database connectivity and communication.
		 * Generate the project.
		 * .zip file of the project will get downloaded then extract it at your workspace directory.
		 * Go to Eclipse
		 * Go to File -> Select Import...
		 * Select Maven -> Import Existing Maven Project 
		 * Select the Project.
		 * Done your project is created.
		 * 
		 * How to configure project?
		 * Project configuration id done using application.properties
		 * 
		 * Repositories
		 * Spring Data JPA provides interfaces for repositories:
		 * Interface							Feature
		 * CrudRepository<T, ID>				Basic CRUD methods (save, findById, delete)
		 * JpaRepository<T, ID>					Extends CrudRepo, adds pagination/sorting
		 * PagingAndSortingRepository<T, ID>	Pagination and sorting support
		 * 
		 * 🎁 What is ApplicationContext?
		 * This is the heart of the Spring Framework. It's the IoC (Inversion of Control) container.
		 * Once your application runs, it returns a context object that contains all your beans.
		 * 
		 * You can use it to fetch beans like this:
		 * MyService service = context.getBean(MyService.class);
		 * 
		 * 🥾 What Does “Bootstraps” Mean in Spring Boot?
		 * In software (and in Spring Boot), "bootstrapping" means:
		 * ✅ Setting up everything needed to get the application up and running.
		 * 
		 * It’s like starting a car:
		 * Turning the key sets off a chain of processes that starts the engine and gets everything running.
		 * 
		 * 💻 In Spring Boot, “bootstrapping” includes:
		 * When you call this:
		 * SpringApplication.run(Demo2Application.class, args);
		 * 
		 * Spring Boot bootstraps the application by doing all of this:
		 * Step	What It Does
		 * 1️	Creates an ApplicationContext (IoC container)
		 * 2️	Loads configuration from application.properties or application.yml
		 * 3️	Scans the classpath for beans (@Component, @Service, @Repository, @Controller)
		 * 4️	Auto-configures beans based on your dependencies (thanks to @SpringBootApplication)
		 * 5️	Starts an embedded server (like Tomcat/Jetty) if it's a web app
		 * 6️	Runs any CommandLineRunner or ApplicationRunner beans you’ve defined
		 * 7️	Makes the app fully ready to serve requests
		 */

		ApplicationContext context = SpringApplication.run(Demo2Application.class, args);
		System.out.println("App started");
		UsersServices usersService = context.getBean(UsersServicesImpl.class);

//		Users u1 = new Users(1,"user1",18,"Mahad");
//
//		usersService.addUser(u1);
//
//		List<Users> users = new ArrayList<Users>();
//		
//		Users u2 = new Users(2,"user2",20,"Satara");
//		Users u3 = new Users(3, "user3",20,"Pune");
//		users.add(u2);
//		users.add(u3);
//		
//		usersService.addMultipleUsers(users);
//
//		List<Users> allUsers = usersService.getUsers();
//		allUsers.forEach((user) -> {
//			System.out.println(user.getId()+" | "+user.getUserName());
//		});
//
//		Users gotuser = usersService.getUserById(2);
//		System.out.println(gotuser.getId() + " | " + gotuser.getUserName());
		
//		Users u4 = usersService.getUserByName("user2");
//		System.out.println(u4.getId() + " " + u4.getCity());
		
//		String u4 = usersService.getUserByName("user2");
//		System.out.println(u4);
		
//		List<Users> u5 = usersService.getUsersByAge(20);
//		u5.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u6 = usersService.getUsersByAgeGreaterThanOrEquals(18);
//		u6.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u7 = usersService.getUsersByAgeLessThan(20);
//		u7.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		Users u8 = new Users(4,"user4",22,"Satara");
//		Users u9 = new Users(5,"user5",25,"Pune");
//		Users u10 = new Users(6,"user6",28,"Nashik");
//		users.add(u8);
//		users.add(u9);
//		users.add(u10);
//		usersService.addMultipleUsers(users);
		
//		List<Users> u11 = usersService.getUsersByAgeBetween(20,28);
//		u11.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u12 = usersService.getUsersByUserNameLike("%use%");
//		u12.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u13 = usersService.getUsersByUserNameEndingWith("er2");
//		u13.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u14 = usersService.getUsersInDescOrderOfAge(18);
//		u14.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u14 = usersService.getUsersByName("user1");
//		u14.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		List<Users> u15 = usersService.getUsersByNativeQuery("user1");
//		u15.forEach((user) -> {
//			System.out.print(user.getId()+" | ");
//			System.out.print(user.getUserName()+" | ");
//			System.out.print(user.getAge()+" | ");
//			System.out.println(user.getCity());
//		});
		
//		System.out.println(usersService.deleteUsersUsingJPQL("user6"));
//		System.out.println(usersService.updateUserNative("user1", "updated name 1"));
		
//		List<UserNameOnly> u16 = usersService.getOnlyNames("Pune");
//		u16.forEach((user) -> {
//			System.out.println(user.getUserName());
//		});
		
//		List<UsersDTO> u17 = usersService.getOnlyNamesAndAge("Pune");
//		u17.forEach((user) -> {
//			System.out.println(user.getUserName() + " | " + user.getAge());
//		});
		
//		List<Users> u18 = usersService.getPagedUsers(18, 3, 2);
//		u18.forEach((user) -> {
//			System.out.println(user.getUserName() + " | " + user.getAge());
//		});
		
//		List<Users> u19 = usersService.customMethod(20);
//		u19.forEach((user) -> {
//			System.out.println(user.getUserName() + " | " + user.getAge());
//		});
	}
}
