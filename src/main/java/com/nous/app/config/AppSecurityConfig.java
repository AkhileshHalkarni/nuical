/**
 * 
 */
package com.nous.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author mohanavelp
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {
		http.csrf().disable();
		http.headers().frameOptions().disable();
    }
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}user123")
            .roles("USER");
        auth.inMemoryAuthentication()
	        .withUser("admin")
	        .password("{noop}admin123")
	        .roles("ADMIN");
        auth.inMemoryAuthentication()
	        .withUser("super")
	        .password("{noop}super123")
	        .roles("ADMIN")
	        .authorities("VIEW_AUTHORITY");
    }
}
