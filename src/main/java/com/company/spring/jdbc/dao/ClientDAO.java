package com.company.spring.jdbc.dao;

import java.util.List;

import com.company.spring.jdbc.model.Client;

public interface ClientDAO {
	//Create
	public void save(Client client);
	
	//Read
	public Client getById(Long id);
	
	//Update
	public void update (Client client);
	
	//Delete
	public void deleteById(Long id);
	
	//Get All
	public List<Client> getAll();
}
