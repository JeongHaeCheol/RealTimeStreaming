package com.sun.fe.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;



@Configuration
public class AuthFailureHandler implements AuthenticationFailureHandler {

	private String loginId = "id";
	private String defaultFailureURI = "/login?error";
	
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException exception)
			throws IOException, ServletException {
		req.setAttribute("id",req.getParameter(loginId));
		req.setAttribute("password", "");
		req.getRequestDispatcher(defaultFailureURI).forward(req, res);
	    //로그인 실패는 세션이나 DB에 영향을 주지 않기 때문에 redirect가 아닌 forward를 사용한다.
		//res.sendRedirect(req.getContextPath() + "/login?error=1");
		
	}

}
