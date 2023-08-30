package com.bank.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	// TODO Auto-generated method stub
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMessage = "Invalid username or password";

		// You can customize the behavior here, such as redirecting to an error page
		// or adding a parameter to the login page to display an error message.

		response.sendRedirect("/login?error=" + errorMessage);
	}

}
