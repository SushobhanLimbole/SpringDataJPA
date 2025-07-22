package com.example.demo2.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo2.customRepo.CustomUsersRepository;
import com.example.demo2.models.Users;
import com.example.demo2.projections.UserNameOnly;
import com.example.demo2.projections.UsersDTO;

import jakarta.transaction.Transactional;

public interface UsersRepo extends JpaRepository<Users, Integer>, CustomUsersRepository {
	
	/*
	 * 🔹Method Query Derivation (Derived Query Methods):
	 * Spring Data JPA can automatically generate queries based on method names.
	 * 
	 * 🧠 How it Works:
	 * You define a method in the repository interface.
	 * Spring parses the method name and creates the SQL/JPQL under the hood.
	 * 
	 * ✅ Syntax Structure
	 * findBy<FieldName><Operator><Conditions>
	 * 
	 * Example:
	 * List<Student> findByName(String name);
	 * 
	 * Spring interprets this as:
	 * SELECT * FROM student WHERE name = ?
	 * 
	 * 📘 Common Keywords
	 * Keyword											Description
	 * findBy, readBy, getBy							Triggers query creation
	 * And, Or											Combines conditions
	 * Is, Equals										Checks equality
	 * Between, LessThan, GreaterThan					Range comparisons
	 * Like, StartingWith, EndingWith, Containing		String matching
	 * In, NotIn										Checks list
	 * True, False										Boolean values
	 * OrderBy											Sorting
	 * 
	 * 
	 * JpaRepository<T, ID> : It has two type parameters
	 * ✅ 1. T – The Entity Type
	 * This is the class that maps to your database table.
	 * It should be annotated with @Entity.
	 * 
	 * ✅ 2. ID – The Primary Key Type
	 * This is the type of the primary key field (usually the @Id field in the entity).
	 * Common types: Long, Integer, UUID, String, etc.
	 */
	
//	1. Find user by name 
//	Using Different returntype : I tried to give String as the return type but it gave me an JpaSystemException
//	stating that the specified result type does not match Query selection type
//	Using Different parameter name : No change in the output
//	Using Different parameter type : It gives an error
	Users findByUserName(String userName);
//	String findByUserName(String userName);
//	Users findByUserName(String para);
//	Users findByUserName(int userName);
	
//	2. Find users by age
//	We can also use :-
//	findAllByAge
//	getByAge
//	getAllByAge
//	readByAge
//	readAllByAge
	List<Users> findByAge(int age);
	
//	3. Find users by age and city , name or city
	List<Users> findByAgeAndCity(int age, String city);
	List<Users> findByUserNameOrCity(String name, String city);
	
//	4. Age Comparisons
	List<Users> findByAgeGreaterThanEqual(int age);
	List<Users> findByAgeLessThan(int age);
	List<Users> findByAgeBetween(int start, int age);
	
//	5. Pattern Matching
	List<Users> findByUserNameLike(String patt);
	List<Users> findByUserNameStartingWith(String patt);
	List<Users> findByUserNameEndingWith(String patt);
	List<Users> findByUserNameContaining(String patt);
	
//	6. IN Queries
	List<Users> findByCityIn(List<String> cities);
	List<Users> findByCityNotIn(List<String> cities);
	
//	7. OrderBy
//	We have to give atleast 1 parameter for the Method Query Derivation to work
	List<Users> findByAgeGreaterThanOrderByAgeDesc(int age);
	
	/*
	 * 🔹JPQL (@Query with JPQL)
	 * JPQL stands for Java Persistence Query Language.
	 * Here, nativeQuery = false by default.
	 * ✅ It works on entity objects, not table/column names.
	 * 
	 * 💡 Syntax:
	 * @Query("SELECT s FROM Student s WHERE s.name = :name")
	 * 
	 * 🧩 JPQL uses:
	 * Entity class name (Student)
	 * Entity fields (s.name, not column names)
	 * 
	 * @Query Annotation (JPQL & Native SQL)
	 * The @Query annotation allows you to write custom queries in your repository methods using:
	 * JPQL (Java Persistence Query Language) — object-oriented, uses entity class names
	 * Native SQL — raw SQL using table/column names
	 */
	
	@Query("SELECT u FROM Users u WHERE u.userName = :name")
	List<Users> getByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM users WHERE user_name = :name", nativeQuery = true)
	List<Users> getUsersNative(@Param("name") String name);
	
	/*
	 * @Modifying + @Transactional (for update/delete queries)
	 * Spring Data JPA does not allow modifying the database using plain @Query.
	 * To perform update or delete using @Query, you must add:
	 * @Modifying – to tell Spring it’s a DML operation (not SELECT)
	 * @Transactional – to manage the transaction boundary
	 * 
	 * 🔄 Use Case Flow
	 * Operation					Annotation Required
	 * SELECT query					@Query only
	 * UPDATE/DELETE (JPQL)			@Modifying + @Transactional
	 * UPDATE/DELETE (Native)		@Modifying + @Transactional + nativeQuery = true
	 * 
	 * 🔍 Summary Table
	 * Feature			Use								Example
	 * @Query (JPQL)	Custom SELECT with entities		@Query("FROM Users u WHERE u.age > :age")
	 * @Query (Native)	Custom raw SQL					@Query(value = "SELECT * FROM users", nativeQuery = true)
	 * @Modifying		Mark method as modifying data	For UPDATE, DELETE
	 * @Transactional	Required for DML to commit		Use with @Modifying
	 */
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Users u WHERE u.userName = :name")
	int deleteUserJPQL(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE users SET user_name = :updatedName WHERE user_name = :name", nativeQuery = true)
	int updateUserNative(@Param("name") String name, @Param("updatedName") String updatedName);
	
	/*
	 * ✅ What is Projections?
	 * 🔹 Problem:
	 * You want to fetch only some fields from the database — not the whole entity.
	 * 
	 * 🔹 Solution:
	 * Spring JPA lets you project only specific fields using:
	 * Interface-based projection
	 * DTO (class) projection
	 * 
	 * ✅ 1. Interface-Based Projection
	 * You define an interface that matches the fields you want.
	 * 
	 * 🔧 Step 1: Create the interface
	 * public interface UserNameOnly {
	 * 		String getName();
	 * }
	 * 
	 * 🔧 Step 2: Use in repository
	 * List<UserNameOnly> findByCity(String city);
	 * 
	 * ➡️ Spring will only fetch the name field (not the whole Users object).
	 * 
	 * ✅ 2. DTO/Class-Based Projection
	 * Use this when:
	 * You want to return a custom class
	 * You need more control (e.g., calculated fields)
	 * 
	 * 🔧 Step 1: Create DTO class
	 * public class UserDTO {
	 * 
	 * 		private String name;
	 * 		private int age;
	 * 
	 * 		public UserDTO(String name, int age) {
	 * 			this.name = name;
	 * 			this.age = age;
	 * 		}
	 * 
	 * 		// getters
	 * }
	 * 
	 * 🔧 Step 2: Use JPQL with new keyword
	 * @Query("SELECT new com.example.UserDTO(u.name, u.age) FROM Users u")
	 * List<UserDTO> getUserSummary();
	 * 
	 * It also works with Method Query Derivation.
	 */
	
	List<UserNameOnly> findByCity(String city);
//	List<UsersDTO> getByCity(String city); 

	@Query("SELECT new com.example.demo2.projections.UsersDTO(u.userName,u.age) FROM Users u WHERE u.city = :city")
	List<UsersDTO> getByCity(@Param("city") String city);
	
	/*
	 * ✅ What is Pagination?
	 * 🔹 Problem:
	 * Imagine you have 10,000 records in a Users table. You don’t want to load all at once.
	 * 
	 * 🔹 Solution:
	 * Pagination allows you to fetch a small chunk of data at a time — e.g., 10 or 20 records per page.
	 * 
	 * ✅ How it Works in Spring Data JPA:
	 * You use the Pageable interface and Spring automatically adds LIMIT and OFFSET to the SQL.
	 * 
	 * 🔧 Example:
	 * Page<Users> findByCity(String city, Pageable pageable);
	 * 
	 * 🔄 Usage:
	 * Pageable pageable = PageRequest.of(0, 5); // page 0, size 5
	 * Page<Users> page = usersRepo.findByCity("Pune", pageable);
	 * List<Users> users = page.getContent();
	 * 
	 * 🧠 Terms
	 * Term			Meaning
	 * Page			A page of results (includes total count, page number, etc.)
	 * Pageable		Object to tell Spring: page number, size, sorting
	 * Slice		Like Page but doesn't fetch total count (faster)
	 * 
	 * ✅ Sorting
	 * Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
	 * Page<Users> page = usersRepo.findAll(pageable);
	 * 
	 * Page is zero based.
	 */
	
	Page<Users> readByAgeGreaterThanEqual(int age, Pageable pageable);
	
	/*
	 * ✅ Custom Repositories & Custom Methods
	 * 🔹 Problem:
	 * Sometimes you need complex logic that can’t be written using method names or even @Query.
	 * 
	 * ✅ Solution: Implement your own method using EntityManager.
	 * 🔧 Step-by-Step Example
	 * 
	 * ✅ Step 1: Create a custom interface
	 * public interface UsersCustomRepository {
	 * 		List<Users> findUsersCustomLogic();
	 * }
	 * 
	 * ✅ Step 2: Implement the interface
	 * @Repository
	 * public class UsersCustomRepositoryImpl implements UsersCustomRepository {
	 * 
	 * 		@PersistenceContext
	 * 		private EntityManager em;
	 * 
	 * 		@Override
	 * 		public List<Users> findUsersCustomLogic() {
	 * 			// Write dynamic query logic
	 * 			return em.createQuery("SELECT u FROM Users u WHERE u.age > 25", Users.class)
	 * 				     .getResultList();
	 * 		}
	 * }
	 * 
	 * ✅ Step 3: Extend in your main repository
	 * public interface UsersRepository extends JpaRepository<Users, Long>, UsersCustomRepository {
	 * }
	 * 
	 * Now you can call:
	 * usersRepository.findUsersCustomLogic();
	 */
}
