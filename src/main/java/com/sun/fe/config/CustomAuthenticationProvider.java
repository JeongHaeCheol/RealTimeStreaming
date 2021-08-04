package com.sun.fe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.sun.fe.model.Account;
import com.sun.fe.service.AccountService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private AccountService accountService;
    
    
    private final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    
 
    @SuppressWarnings("unchecked")
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = (String) authentication.getName();
        String password = (String) authentication.getCredentials();
        
        logger.info("CustomAuthenticationProvider 테스트 : " + username + ", " + password);
        
        Account account = (Account) accountService.loadUserByUsername(username);
        
        if(!matchPassword(password, account.getPassword())) {
            throw new BadCredentialsException(username);
        }
 
        if(!account.isEnabled()) {
            throw new BadCredentialsException(username);
        }
        
        return new UsernamePasswordAuthenticationToken(username, password, account.getAuthorities());
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
    private boolean matchPassword(String loginPwd, String password) {
    	logger.info("Password 비교 테스트 : " + loginPwd + ", " + password);
        return loginPwd.equals(password);
    }
 
}
