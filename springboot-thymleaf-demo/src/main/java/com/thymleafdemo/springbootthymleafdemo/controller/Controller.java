package com.thymleafdemo.springbootthymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thymleafdemo.springbootthymleafdemo.entities.Employee;
import com.thymleafdemo.springbootthymleafdemo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class Controller {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public List<Employee> getAllEmployess(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	@GetMapping("/id/{id}")
	public Employee getById(@PathVariable("id") String id) {
		return employeeService.getByID(id);
	}
	
	@GetMapping("/email/{email}")
	public Employee getByEmail(@PathVariable("email") String email) {
		return employeeService.getByEmailId(email);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") String id) {
		return employeeService.deleteByID(id);
	}
	

    
    
}
