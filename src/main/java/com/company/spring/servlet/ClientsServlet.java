package com.company.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.company.spring.ApplicationInitializer;
import com.company.spring.jdbc.dao.ClientDAO;
import com.company.spring.jdbc.model.Client;

import com.google.gson.Gson;



@WebServlet("/ClientsServlet")
public class ClientsServlet extends HttpServlet {
	
	public ClientDAO clientDAO  = ApplicationInitializer.getAppContext().getBean(ClientDAO.class);
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String buttonId = request.getParameter("button-id");
		switch (buttonId) {
			case "listClients":
				List<Client> clientList = clientDAO.getAll();
				String json = null;
				
				json = new Gson().toJson(clientList);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);			
				break;
			case "removeClient":
				Long identityNumber = Long.parseLong(request.getParameter("identityNumber"));
				clientDAO.deleteById(identityNumber);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonId = request.getParameter("button-id");
		Client client = new Client();
		Long identityNumber = Long.parseLong(request.getParameter("identityNumber"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		client.setClient(identityNumber, firstName, lastName, address, phoneNumber);
		
		switch (buttonId) {
			case "addClient":
				clientDAO.save(client);
				break;
			case "editClient":
				clientDAO.update(client);
				break;
		}
	}

}
