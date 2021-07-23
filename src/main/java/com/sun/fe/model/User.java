package com.sun.fe.model;

import lombok.Data;



@Data
public class User {
	
	private int uid;
	
	// used as id
	private String username;
	
	private String password;
	
/*	@NotEmpty(message="The User email must not be null")
	private String email;*/
	
	
	private boolean enabled=false;
	
	private String authority;
	
	
}