package com.aa.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 125, unique = true)
	@Email(message = "E-mail is not valid!")
	@Length(min = 5, max = 125, message = "E-mail must have 5-125 characters!")
	private String email;
	
	@Column(length = 64, nullable = false)
	@NotBlank(message = "Password is required!")
	@Length(min = 5, max = 64, message = "Password must have 5-64 characters!")
	private String password;
	
	@Column(name = "first_name", length = 45, nullable = false)
	@NotBlank(message = "First Name is required!")
	@Length(min = 2, max = 45, message = "First Name must have 2-45 characters!")
	private String firstName;
	
	@Column(name = "last_name", length = 45, nullable = false)
	@NotBlank(message = "Last Name is required!")
	@Length(min = 2, max = 45, message = "Last Name must have 2-45 characters!")
	private String lastName;
	
	private boolean enabled;
	
	public User(String email, String password, String firstName, String lastName, boolean enabled) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
	}

	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
