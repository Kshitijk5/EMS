package com.thymleafdemo.springbootthymleafdemo.securityconfig;

//import java.util.Collection;
import java.util.Set;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thymleafdemo.springbootthymleafdemo.entities.Employee;
import com.thymleafdemo.springbootthymleafdemo.repository.EmployeeRepo;

@Service
public class CustomUserService implements UserDetailsService {
     
	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  
		        Employee employee = employeeRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("No user with Username"+username+" existss"));

		        Set<GrantedAuthority> roles = employee.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		       return new User(employee.getEmail(),employee.getPassword(),roles);
	}

}
