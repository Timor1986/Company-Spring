package com.company.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.company.spring.jdbc.model.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JobDAOImpl implements JobDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Job> getAll() {
		String query = "SELECT * FROM jobs";
		List<Job> jobList = new ArrayList<Job>();
		
		List<Map<String,Object>> jobRows = jdbcTemplate.queryForList(query);
		
		for (Map<String,Object> jobRow : jobRows) {
			Job job = new Job();
			
			job.setJob((Long)jobRow.get("id")
					,(String)jobRow.get("name")
					,(Long)jobRow.get("salary"));
			jobList.add(job);
		}
		return jobList;
	}

	@Override
	public void save(Job job) {
		String query = String.format("INSERT INTO jobs (id,name,salary) VALUES (%d%n,'%s',%d%n)",
				job.getId(),
				job.getName(),
				job.getSalary());
		jdbcTemplate.execute(query);
	}

	@Override
	public Job getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Job job) {
		String query = String.format("Update jobs SET name='%s', salary=%d%n WHERE id = %d%n",
				job.getId(),
				job.getName(),
				job.getSalary()
				);
		jdbcTemplate.execute(query);
	}

	@Override
	public void deleteById(Long id) {
		String query = "Delete FROM jobs WHERE id ='" + id + "'";
		jdbcTemplate.execute(query);
	}
}
