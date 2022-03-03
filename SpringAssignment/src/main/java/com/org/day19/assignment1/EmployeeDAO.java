package com.org.day19.assignment1;

import com.org.day19.assignment1.*;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	private static Employees list = new Employees();
	
	static {
		list.getEmployeeList().add(new Employee(1, "Sidharth", "Malhotra", "sidharth@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Tarun", "Singh", "tarun@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "Ankush", "Rana", "ankush@gmail.com"));
	}
	
	//method to return the list
	public Employees getAllEmployees() {
		
		return list;
	}
	
	//method to add an employee to the list
	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}
}
