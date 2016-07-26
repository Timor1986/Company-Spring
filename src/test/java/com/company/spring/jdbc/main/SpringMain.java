package com.company.spring.jdbc.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.spring.jdbc.dao.ClientDAO;
import com.company.spring.jdbc.model.Client;

public class SpringMain {
	public static void main(String[] args) {
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the ClientDAO Bean
		ClientDAO clientDAO = ctx.getBean("clientDAO",ClientDAO.class);
		
		//Run tests
		//Client client = new Client();
		
		//Add Client
		Client client = new Client();
		client.setClient(Long.parseLong("111111111"), "Gigi", "Rivera", "Brazzers 13", Long.parseLong("092215411"));
		clientDAO.save(client);
		
		//Edit Client
		client.setClient(Long.parseLong("111111111"), "Gigi", "Rivera", "Brazzers 14", Long.parseLong("092215411"));
		clientDAO.update(client);
		
		//Get All
		List<Client> clientList = clientDAO.getAll();
		System.out.println(clientList);
		
		//Close Spring Context
		ctx.close();		
		System.out.println("DONE");
	}
}
