package com.company.spring.jdbc.dao;

import java.util.List;

import com.company.spring.jdbc.model.Job;

public interface JobDAO {
	//Create
	public void save(Job job);
	
	//Read
	public Job getById(Long id);
	
	//Update
	public void update (Job job);
	
	//Delete
	public void deleteById(Long id);
	
	//Get All
	public List<Job> getAll();
}
