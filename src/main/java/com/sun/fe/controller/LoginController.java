package com.sun.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.fe.mapper.AccountMapper;
import com.sun.fe.model.Account;
import com.sun.fe.model.User;
import com.sun.fe.service.AccountService;




@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	AccountService accountService;
	
	
	@Autowired
	AccountMapper accountMapper;

	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, Model model, Account account) {
				
		
		
		if (error!=null){
			model.addAttribute("errorMsg","Invalid username and password");
		}
		if(logout!=null){
			model.addAttribute("logoutMsg", "You have been logged out successfully");
		}
		
		return "login";
		
	}
	
	
	@RequestMapping("/create")
	public Account create() {
		Account account = new Account();
		account.setId("admin");
		account.setPassword("1234");
		accountService.save(account, "ROLE_ADMIN");
		return account;
	}
	
}
