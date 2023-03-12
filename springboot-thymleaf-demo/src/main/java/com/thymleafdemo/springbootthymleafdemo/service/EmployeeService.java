package com.thymleafdemo.springbootthymleafdemo.service;

import java.util.List;
import com.thymleafdemo.springbootthymleafdemo.entities.*;

public interface EmployeeService {
	Employee create(Employee employee);

	List<Employee> getAllEmployees();

	Employee getByID(String id);

	Employee getByEmailId(String email);

	String deleteByID(String id);

}
