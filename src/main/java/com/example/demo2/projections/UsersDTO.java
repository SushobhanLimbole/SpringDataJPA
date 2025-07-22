package com.example.demo2.projections;

/*
 * This is the DTO/class based Projection
 * Use this when:
 * You want to return a custom class
 * You need more control (e.g., calculated fields)
 * 
 * 🔧 Step 1: Create DTO class
 * 
 * 🔧 Step 2: Use JPQL with new keyword
 * @Query("SELECT new com.example.UserDTO(u.name, u.age) FROM Users u")
 * List<UserDTO> getUserSummary();
 */
public class UsersDTO {
	
	private String userName;
	private int age;
	
	public UsersDTO(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}
}
