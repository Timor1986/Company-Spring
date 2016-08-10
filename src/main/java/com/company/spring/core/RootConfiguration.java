package com.company.spring.core;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.company.spring.jdbc.DataSourceConfig;
import com.company.spring.jdbc.dao.ClientDAO;
import com.company.spring.jdbc.dao.ClientDAOImpl;
import com.company.spring.jdbc.dao.JobDAO;
import com.company.spring.jdbc.dao.JobDAOImpl;
import com.company.spring.servlet.ClientsServlet;

@Configuration
@Import(DataSourceConfig.class)
public class RootConfiguration {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public ClientDAO clientDAO(){
		return new ClientDAOImpl();
	}
	
	@Bean
	public JobDAO jobDAO(){
		return new JobDAOImpl();
	}

}
