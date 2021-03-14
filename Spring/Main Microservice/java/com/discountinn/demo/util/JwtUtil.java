package com.discountinn.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


//Logic for generating and validating tokens
@Service
public class JwtUtil {

    private String secret = "javatechie";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

	//If token is created before 10hrs then return true else return false
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    /*
	 * When first request comes with the username and password, we create a token
	 */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }


    /*
	 *  claims => empty Map object
	 *  subject => username
	 *  
	 *  setting issued date 
	 *  
	 *  
	 *  expiration time of token = 10hrs 
	 *  
	 *  
	 *  Algorithm used for token = HS256
	 *  
	 */
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);	//extracts username from the token

	//validating the username and verifying whether token is expired or not
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}