package com.educacionit.db.model;

public class User {
	
	private Integer id;
	private String name;
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/*public User() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	

}
