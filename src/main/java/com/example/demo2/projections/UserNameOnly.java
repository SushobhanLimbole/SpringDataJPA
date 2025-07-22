package com.example.demo2.projections;

/*
 * This is the Interface based projection of Users.
 * We don't have to implement this interface, Spring Data JPA internally implements by creating a proxy class.
 * 
 * ✅ How It Works Internally
 * Spring Data JPA:
 * Automatically creates a proxy class at runtime (using Spring AOP and reflection) 
 * that implements the projection interface.
 * It maps the selected columns from the query directly to the interface methods.
 * 
 * So, when you write:
 * public interface UserNameOnly {
 *     String getName();
 * }
 * 
 * And then call this:
 * List<UserNameOnly> users = userRepository.findByCity("Pune");
 * 
 * Spring:
 * Executes the query (e.g., SELECT name FROM users WHERE city = 'Pune')
 * Maps the result to a dynamic class that implements UserNameOnly
 * Returns a list of objects that look like they implement UserNameOnly
 * 
 * You just call:
 * for (UserNameOnly u : users) {
 *     System.out.println(u.getName()); // works!
 * }
 * 
 * 🧠 Key Requirements for Interface-Based Projections
 * ✅ The method names in your interface must match the entity field names.
 * ✅ You don’t need to annotate anything special — just define the interface and return it in your repository method.
 *
 * 🔹 1. What is Spring AOP?
 * ✅ AOP = Aspect-Oriented Programming
 * It’s a way to separate cross-cutting concerns from your core business logic.
 *
 * 💡 What are Cross-Cutting Concerns?
 * These are things that affect many parts of your application — like:
 * Logging
 * Security
 * Transactions
 * Performance monitoring
 * Validation
 *
 * Instead of writing these again and again, AOP lets you write them once and apply wherever needed.
 *
 * 🎯 Real-Life Analogy
 * Suppose you have 10 classes, and in each one you write:
 * System.out.println("Method started");
 *
 * With AOP, you can say:
 * "Before any method in package com.example.service runs, automatically print that log."
 * You don’t touch your original classes!
 *
 * 🔧 In Spring, AOP is used for:
 * Use Case			How
 * Logging			Print before/after method calls
 * Transactions		@Transactional uses AOP
 * Security			@PreAuthorize, etc.
 * Caching			@Cacheable, @CacheEvict
 *
 * 🧩 Example
 * @Aspect
 * @Component
 * public class LoggingAspect {
 *
 *    @Before("execution(* com.example.service.*.*(..))")
 *    public void logBefore(JoinPoint joinPoint) {
 *                System.out.println("Calling method: " + joinPoint.getSignature().getName());
 *    }
 * }
 * This runs before any method in com.example.service package.
 * 
 * 🔹 2. What is Reflection in Java?
 * ✅ Reflection = "Looking Inside Java Classes at Runtime"
 * 
 * It lets you:
 * Inspect classes, methods, fields during runtime
 * Access private fields
 * Dynamically call methods or create objects
 * 
 * 🧠 Why is it Useful?
 * Used in:
 * Frameworks like Spring, Hibernate, Jackson
 * Dependency Injection
 * Serialization
 * Testing tools like JUnit, Mockito
 * Runtime proxy generation
 * 
 * 🔧 Example
 * Class<?> clazz = Class.forName("com.example.Users");
 * Object obj = clazz.getDeclaredConstructor().newInstance();
 * Method method = clazz.getMethod("getName");
 * String name = (String) method.invoke(obj);
 * 
 * This is how Spring scans your class and injects dependencies like @Autowired.
 * 
 * 📌 Summary
 * Feature		Meaning												Used In
 * AOP			Code that runs before/after/around other code		Logging, transactions, security
 * Reflection	Inspect and manipulate classes at runtime			DI, proxy objects, serialization
 */

public interface UserNameOnly {
	public String getUserName();
}
