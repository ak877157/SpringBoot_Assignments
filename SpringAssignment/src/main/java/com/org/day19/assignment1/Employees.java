package com.org.day19.assignment1;

import java.util.ArrayList;
import java.util.List;

//class to store list of all employees
public class Employees {

	private List<Employee> employeeList;
	
	//method to return list of employees
	public List<Employee> getEmployeeList(){
		if(employeeList == null) {
			employeeList = new ArrayList<>();
		}
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
}
