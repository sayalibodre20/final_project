package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        csrf().disable()
            .authorizeRequests()
            .antMatchers("/customer/insertCustomer","/swagger/**", "/v*/api-docs/**","/employee/Bank/branch").permitAll()//remove commnet symbol bfeore two asterik 
                .antMatchers("/employee-login").permitAll()
                .antMatchers("/customer-login").permitAll()
                .antMatchers("/employee/**").hasAuthority("employee")
                .antMatchers("/customer/**").hasAuthority("customer")
                .and()
            .formLogin()
            .loginProcessingUrl("/login/**")
                .loginProcessingUrl("/authenticate")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
            .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
    }
//            @Bean
//        	public SecurityFilterChain myAuthorization(HttpSecurity http) throws Exception {
//    	 http.
//         csrf().disable()
//             .authorizeRequests()
//             .antMatchers("/customer/insertCustomer","/swagger*/**", "/v*/api-docs/**","/employee/Bank/branch").permitAll()
//                 .antMatchers("/employee-login").permitAll()
//                 .antMatchers("/customer-login").permitAll()
//                 .antMatchers("/employee/**").hasAuthority("employee")
//                 .antMatchers("/customer/**").hasAuthority("customer")
//                 .and()
//        		.httpBasic(); // support Basic authentication
//
//        		return http.build();
//        	}
}
