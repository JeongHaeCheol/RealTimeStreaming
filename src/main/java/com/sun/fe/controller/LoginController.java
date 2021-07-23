package com.sun.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.fe.model.User;



@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, Model model, User user) {
				
		if (error!=null){
			model.addAttribute("errorMsg","Invalid username and password");
		}
		if(logout!=null){
			model.addAttribute("logoutMsg", "You have been logged out successfully");
		}
		
		
		return "login";
		
	}
	
}
