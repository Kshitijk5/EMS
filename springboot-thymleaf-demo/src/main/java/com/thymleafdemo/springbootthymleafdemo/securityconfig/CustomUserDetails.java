//package com.thymleafdemo.springbootthymleafdemo.securityconfig;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.thymleafdemo.springbootthymleafdemo.entities.Employee;
//
//public class CustomUserDetails implements UserDetails {
//	
//	/**
//	 * 
//	 */
//	
//	private String email;
//	private static final long serialVersionUID = 1L;
//	private Employee employee;
//	
//	public CustomUserDetails(Employee employee) {
//	  this.employee = employee;	
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> roles = employee.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
//        return roles;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return employee.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return employee.getUsername();
//	}
//	public String getEmail() {
//	        return this.employee.getEmail();
//	    }
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	
//}
