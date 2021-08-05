package com.sun.fe.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sun.fe.Repository.AccountRepository;
import com.sun.fe.controller.HomeController;
import com.sun.fe.mapper.AccountMapper;
import com.sun.fe.model.Account;

@Service
public class AccountService implements UserDetailsService {

	private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired PasswordEncoder passwordEncoder;
	

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		Account account = accountRepository.findById(id);

		if (account == null) {
			throw new UsernameNotFoundException("User : " + id + " Not Found");
		}
		account.setAuthorities(getAuthorities(id));

		return account;
	}

	
	private Collection<? extends GrantedAuthority> getAuthorities(String id) {
		List<String> string_authorities = accountRepository.readAuthorities(id);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority));
			
			logger.info(authorities.toString());
		}
		return authorities;

	}

	
	public Account save(Account account, String role) {

		//account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setAccountNonExpired(true);
		account.setAccountNonLocked(true);
		account.setCredentialsNonExpired(true);
		account.setEnabled(true);
		return accountRepository.save(account, role);
	}

}
