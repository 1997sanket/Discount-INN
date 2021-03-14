package com.discountinn.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.discountinn.demo.services.CustomUserDetailsSevice;
import com.discountinn.demo.util.JwtUtil;

//Before user comes to controller, he will come here
@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsSevice service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String authorizationHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNjEwNjc1MzgzLCJpYXQiOjE2MTA2MzkzODN9.nnyiVGakqZaIGKtdRYldFhHLr9UbcaddaL_iivnJ0ws
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);	//Get token only and remove "Bearer"
			
			username = jwtUtil.extractUsername(token);	
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = service.loadUserByUsername(username);
			
			//If token is valid, then check user details, if user details is valid 
			if(jwtUtil.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}
}
