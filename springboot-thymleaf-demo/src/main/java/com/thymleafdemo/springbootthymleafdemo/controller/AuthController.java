package com.thymleafdemo.springbootthymleafdemo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymleafdemo.springbootthymleafdemo.entities.Employee;
import com.thymleafdemo.springbootthymleafdemo.entities.Roles;
import com.thymleafdemo.springbootthymleafdemo.repository.EmployeeRepo;
import com.thymleafdemo.springbootthymleafdemo.repository.RoleRepo;
import com.thymleafdemo.springbootthymleafdemo.service.EmployeeService;

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class AuthController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired 
	private PasswordEncoder passwordEncoder; 

	@GetMapping("/login")
	public String login() {
		return "login-page";
	}

	@GetMapping("/main")
	public String mainPage() {
		return "main-page";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("employee", new Employee());
		return "register-page";
	}

	@PostMapping("/registerprocess")
	public String registerProcessor(@Valid @ModelAttribute("employee") Employee responseEmployee, BindingResult result,
			Model model) throws Exception {
		if (!result.hasErrors()) {
			if (employeeRepo.existsByUsername(responseEmployee.getUsername())) {
				throw new Exception("Username is already exists!.");
			}

			// add check for email exists in database
			if (employeeRepo.existsByEmail(responseEmployee.getEmail())) {
				throw new Exception("Email is already exists!.");
			}
			Roles role = roleRepo.findByName("ROLE_USER");
			Set<Roles> roles = new HashSet<>();
			responseEmployee.setPassword(passwordEncoder.encode(responseEmployee.getPassword()));
			roles.add(role);
			responseEmployee.setRoles(roles);
			employeeService.create(responseEmployee);
			return "login-page";
		} else {
			model.addAttribute("employee", responseEmployee);
			return "register-page";
		}

	}

}
