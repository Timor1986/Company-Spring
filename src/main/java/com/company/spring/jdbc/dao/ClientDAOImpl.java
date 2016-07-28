package com.company.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.company.spring.jdbc.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ClientDAOImpl implements ClientDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Client> getAll() {
		String query = "SELECT * FROM clients";
		List<Client> clientList = new ArrayList<Client>();
		
		List<Map<String,Object>> clientRows = jdbcTemplate.queryForList(query);
		
		for (Map<String,Object> clientRow : clientRows) {
			Client client = new Client();
			
			client.setClient((Long)clientRow.get("identity_number")
					,(String)clientRow.get("first_name")
					,(String)clientRow.get("last_name")
					,(String)clientRow.get("address")
					,(Long)clientRow.get("phone"));
			clientList.add(client);
		}
		return clientList;
	}

	@Override
	public void save(Client client) {
		
		String query = String.format("INSERT INTO clients (identity_number,first_name,last_name,address,phone) VALUES (%d%n,'%s','%s','%s',%d%n)",
				client.getIdentityNumber(),
				client.getfirstName(),
				client.getLastName(),
				client.getAddress(),
				client.getPhoneNumber()
				);
		jdbcTemplate.execute(query);
	}

	@Override
	public Client getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Client client) {
		String query = String.format("Update clients SET first_name='%s', last_name='%s', address='%s', phone=%d%n WHERE identity_number = %d%n",
				client.getfirstName(),
				client.getLastName(),
				client.getAddress(),
				client.getPhoneNumber(),
				client.getIdentityNumber()
				);
		jdbcTemplate.execute(query);
	}

	@Override
	public void deleteById(Long id) {
		String query = "Delete FROM clients WHERE identity_number ='" + id + "'";
		jdbcTemplate.execute(query);
	}
}
