package com.org.day19.assignment1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path="/employees")

public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	//Implementing GET method to get list of all employees
	@GetMapping(path="/", produces ="application/json")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	//creating a POST method to add an Employee to the list
	@PostMapping(path="/", consumes="application/json", produces="application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		//creating an ID of an employee from the no. of employees
		
		int id = employeeDao.getAllEmployees().getEmployeeList().size()+1;
		
		employee.setId(id);
		employeeDao.addEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	

}
