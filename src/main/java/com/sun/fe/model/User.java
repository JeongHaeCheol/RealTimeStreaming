package com.sun.fe.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;


@Data
public class User {
	private String id;
	private String password;
	private boolean isAccountNonExpired; 
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired; 
	private boolean isEnabled;
	private Collection <? extends GrantedAuthority> authorities;

}
