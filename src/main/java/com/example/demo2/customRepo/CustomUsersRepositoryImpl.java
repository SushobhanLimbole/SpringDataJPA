package com.example.demo2.customRepo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo2.models.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/*
 * ✅ 1. @Repository
 * 🔹 What is it?
 * It is a Spring annotation used to indicate that the class is a Data Access Object (DAO).
 * It tells Spring: "This class is responsible for interacting with the database."
 * 
 * 🔹 What does it do?
 * Registers the class as a Spring Bean (so you can use @Autowired).
 * Provides exception translation: converts low-level database exceptions into Spring’s DataAccessException.
 * 
 * 🔹 Usage:
 * @Repository
 * public interface UserRepository extends JpaRepository<User, Long> {
 * }
 * 
 * You don’t need to write @Repository if you extend JpaRepository, 
 * because Spring will automatically detect it through component scanning.
 * 
 * ✅ 2. EntityManager
 * 🔹 What is it?
 * It is the main interface provided by JPA for managing the persistence (saving, updating, deleting)
 * of entities.
 * It's similar to Session in Hibernate.
 * 
 * 🔹 What can it do?
 * persist() – insert a new entity
 * merge() – update an entity
 * remove() – delete an entity
 * find() – get by primary key
 * createQuery() – run JPQL
 * createNativeQuery() – run raw SQL
 * 
 * 🔹 Example:
 * @Autowired
 * private EntityManager entityManager;
 * 
 * public User getUserById(Long id) {
 *     return entityManager.find(User.class, id);
 * }
 * 
 * ✅ 3. @PersistenceContext
 * 🔹 What is it?
 * It is an annotation used to inject the EntityManager into your class.
 * 💡 Behind the scenes, it manages the lifecycle and scoping of the EntityManager 
 * for each transaction or request.
 * 
 * 🔹 Why use it?
 * It’s more reliable than @Autowired for EntityManager because:
 * It ensures thread safety
 * Uses a transaction-scoped EntityManager by default
 */

@Repository
public class CustomUsersRepositoryImpl implements CustomUsersRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Users> customLogicGetUsersByAge(int age) {
		try {
			System.out.println("customLogicGetUsersByAge called");
			String query = "SELECT u FROM Users u WHERE u.age > :age";
			TypedQuery<Users> q = em.createQuery(query, Users.class);
			q.setParameter("age", age);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
