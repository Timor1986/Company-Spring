package com.company.spring.jdbc.model;

//Erez test 
public class Job {
	private Long id;
	private String name;
	private Long salary;
	
	public void setJob(Long id, String name, Long salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Long getSalary() {
		return this.salary;
	} 
}
