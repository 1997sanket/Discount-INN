package com.discountinn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.discountinn.demo.filter.JwtFilter;
import com.discountinn.demo.services.CustomUserDetailsSevice;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsSevice userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	
	
	//RestTemplate Bean
	@Bean
	public RestTemplate getTemplate() {
		
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter());
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		return template;
	}
	
	//For spring version above 2
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().disable();
		//In short, don't apply security for "/authenticate" url 
		 http.csrf().disable().authorizeRequests().antMatchers (
				 "/authenticate", 
				 "/booking",
				 "/booking/{bookingId}",
				 "/hotels/state/{state}",
				 "/hotels/{hotelId}",
				 "/main-booking",
				 "/main-booking/{id}",
				 "/billing/{bookingId}",
				 "/printPdf",
				 "/emailPdf",
				 "/hotelsByPinCode/{pinCode}",
				 "/states",
				 "/hotels/city/{city}",
					"/CheckOutBooking/{bookingId}",
					"/city/{id}"
				 )
		 
		 
		 .permitAll().antMatchers(HttpMethod.OPTIONS, "/**") 
         .permitAll().anyRequest().authenticated()
         .and().exceptionHandling().and().sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
	}

}
