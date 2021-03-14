package com.discountinn.demo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.discountinn.demo.models.Booking;
import com.discountinn.demo.models.Staff;
import com.discountinn.demo.repositories.BookingRepository;
import com.discountinn.demo.repositories.StaffRepository;

@SpringBootApplication
@EnableAsync
public class DiscountInnApplication {
	
	@Autowired
	private StaffRepository repo;
	
	
	 @PostConstruct	//So that this method is invoked on application startup
	public void initUsers() {
		
		//Creating Staff objects 
			List<Staff> members = Stream.of(	
				new Staff("root", "aA@1", 1),
				new Staff("sanket", "sS@1", 2)
				
				).collect(Collectors.toList());
		
		//Saving these Staff objects in the Staff table
		repo.saveAll(members); 
		
	} 
	
	
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*")
				
				.allowedMethods("*")
					.allowCredentials(false); 
			}
		};
	} */
	
	
	/*@Bean
	public FilterRegistrationBean simpleCorsFilter() {  
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
	    CorsConfiguration config = new CorsConfiguration();  
	    config.setAllowCredentials(true); 
	    // *** URL below needs to match the Vue client URL and port ***
	    config.setAllowedOrigins(Collections.singletonList("*")); 
	    config.setAllowedMethods(Collections.singletonList("*"));  
	    config.setAllowedHeaders(Collections.singletonList("*"));  
	    source.registerCorsConfiguration("/**", config);  
	    FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
	    return bean;  
	}   */
	
	
	
//	  @Bean
//	    public WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurerAdapter() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE",
//	                        "GET", "POST");
//	            }
//	        };
//	    }
//	
//	

		//To avoid cors error
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**");
	            }
	        };
	    }


	    
	    public static void main(String[] args) {
			SpringApplication.run(DiscountInnApplication.class, args);
		}
	

}
