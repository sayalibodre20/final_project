package com.bank.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bank.security.CustomerPrincipal;
import com.bank.security.EmployeePrincipal;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
		 @Override
		    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
		        // Get authorities (roles) of the authenticated user
			 UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		        if (userDetails instanceof CustomerPrincipal) {
		            response.sendRedirect("/customer/Custid");
		        } else if (userDetails instanceof EmployeePrincipal) {
		            response.sendRedirect("/employee/EmpId");
		        } else {
		            response.sendRedirect("/"); // Default redirect if neither employee nor customer
		        }
		    }

	}


