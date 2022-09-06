package com.aa.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.exception.NotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll() {
		return repo.findAll();
	}
	
	public User get(Integer id) throws NotFoundException {
		try {
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Could not find any User with ID: " + id);
		}
	}
	
	public User save(User user) {
		return repo.save(user);
	}

	public void delete(Integer id) throws NotFoundException {
		if (!repo.existsById(id)) {
			throw new NotFoundException("Could not find any User with ID: " + id);
		}
		
		repo.deleteById(id);
	}
}
