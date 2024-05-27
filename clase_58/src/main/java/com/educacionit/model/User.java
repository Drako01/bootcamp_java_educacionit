package com.educacionit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 255, unique = true)
	private String username;

	@Column(nullable = false, length = 255, unique = false)
	@JsonIgnore
	private String password;

	@Column(nullable = true, length = 255, unique = false)
	private String email;

	@Column(nullable = true, length = 255, unique = false)
	private String phone;

	@Column(nullable = true, length = 255, unique = false)
	private String name;

	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))	
	@JsonIgnore
	private Set<Role> roles = new HashSet<>();

	public void addRole(Role role) {
		this.roles.add(role);
	}

	
}