package com.educacionit.map;

public class Persona {

	private Integer id;
	private String name;
	public Persona() {
		
	}
	public Persona(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
		return "Persona [id = " + id + ", name = " + name + "]";
	}
	
	
}
