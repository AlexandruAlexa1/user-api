package com.aa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aa.user.User;
import com.aa.user.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("a1@yahoo.com", "password", "AA", "AA", true);
		User user2 = new User("a2@yahoo.com", "password", "AA", "AA", true);
		User user3 = new User("a3@yahoo.com", "password", "AA", "AA", true);
		User user4 = new User("a4@yahoo.com", "password", "AA", "AA", true);
		User user5 = new User("a5@yahoo.com", "password", "AA", "AA", true);

		repo.saveAll(List.of(user1, user2, user3, user4, user5));
		
		System.out.println("Database initialized");
	}

}
