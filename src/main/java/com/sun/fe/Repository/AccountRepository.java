package com.sun.fe.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.fe.mapper.AccountMapper;
import com.sun.fe.model.Account;
import com.sun.fe.service.AccountService;

@Repository
public class AccountRepository {

	private final static Logger logger = LoggerFactory.getLogger(AccountRepository.class);

	@Autowired
	AccountMapper accountMapper;

	public Account save(Account account, String role) {
		accountMapper.insertUser(account);
		accountMapper.insertUserAutority(account.getId(), role);
		return account;
	}

	public Account findById(String id) {
		return accountMapper.readAccount(id);
	}

	public List<String> findAuthoritiesbyid(String username) {
		return accountMapper.readAutorities(username);
	}

	public List<String> readAuthorities(String id) {
		return accountMapper.readAutorities(id);
	}
}