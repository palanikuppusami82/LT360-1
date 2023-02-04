package com.ladera;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Ladera360Application {

	public static void main(String[] args) {
		SpringApplication.run(Ladera360Application.class, args);
	}

	
	 @Bean
	    public CorsFilter corsFilter() {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        final CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.setAllowedOrigins(List.of("http://localhost:4200"));
	        config.addAllowedHeader("*");
	        config.addExposedHeader("Authorization");
	        config.addAllowedMethod("OPTIONS");
	        config.addAllowedMethod("HEAD");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("DELETE");
	        config.addAllowedMethod("PATCH");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	 
	    @Bean
		public ModelMapper modelMapper()
		{
	        ModelMapper modelMapper = new ModelMapper();
	    	 modelMapper.getConfiguration()
	         .setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper;
		}
}
