package com.educacionit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
	@Column(nullable = false, length = 255, unique = true)
    private String name;
    
	@Column(nullable = true, length = 255, unique = false)
    private String description;
    
    
}