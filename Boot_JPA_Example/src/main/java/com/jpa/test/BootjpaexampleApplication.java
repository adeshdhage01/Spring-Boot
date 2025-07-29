package com.jpa.test;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.Query;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {
	
    private final UserRepository userRepository;

    BootjpaexampleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public static void main(String[] args) {
		System.out.println("CRUD App Started....");
		
	 ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
	 UserRepository userRepository = context.getBean(UserRepository.class);
	 
	 //Create Data
	 
//	 User u1 = new User();
//	 u1.setCity("Nashik");
//	 u1.setName("Vivek");
//	 u1.setStatus("Software Tester");
//	 
//	 User result = userRepository.save(u1);
//	 System.out.println(result);
	 
//	 //Read Data
//	 Iterable<User> users = userRepository.findAll();
//	 
//	 for(User i:users) {
//		 System.out.println(i);	 
//	 }

//	 //Update Data
//	 Optional<User> user = userRepository.findById(52);
//	 User u1 = user.get();
//	 u1.setCity("Pune");
//	 u1.setName("Rahul");
//	 
//	 userRepository.save(u1);
//	 System.out.println("User Updated...");
	 
//	 Delete Data
//	 userRepository.deleteById(52);
//	 System.out.println("User Deleted...");
	 
//	 find by name
//	 List<User> byName = userRepository.findByName("Adesh");
//	 System.out.println(byName);
	 
//	 find by name and city
//	 List<User> byNameAndCity = userRepository.findByNameAndCity("Adesh","Akole");
//	 System.out.println(byNameAndCity);
	 
	 //get all users by using JPQL
//	 List<User> all = userRepository.getAll();
//	 for(User i:all)
//	 {
//		 System.out.println(i);
//	 }

	 
	 //Get user by using name in JPQL
//	 List<User> userByName = userRepository.getUserByName("Yogesh");
//	 System.out.println(userByName);

	 
	 //Get all users using SQL query
	 List<User> allUsers = userRepository.getAllUsers();
	 for(User i: allUsers) {
		 System.out.println(i);
	 }
	}

}
