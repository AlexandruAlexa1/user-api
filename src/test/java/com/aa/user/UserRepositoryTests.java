package com.aa.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		User user = new User("aa@yahoo.com", "password", "AA", "AA", true);
		
		User savedUser = repo.save(user);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
		assertThat(savedUser).isNotNull();
	}
	
	
}
