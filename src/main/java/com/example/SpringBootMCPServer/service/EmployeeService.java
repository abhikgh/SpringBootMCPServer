package com.example.SpringBootMCPServer.service;


import com.example.SpringBootMCPServer.entity.Employee;
import com.example.SpringBootMCPServer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	//in Transactional scope so that TransactionManager creates a new EntityManager and the connection to the database remains open till the transaction is complete
	//As soon as the first employee arrives, the client can act on them, and underlying database resources remain open while processing all users in the stream.
	@Transactional
	public List<Employee> findByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName).map(employee -> {
			employee.setAccount("aaa");
			return employee;
		}).toList();
	}
}
