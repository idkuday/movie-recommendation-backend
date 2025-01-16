package com.blitzmovierec.film_finder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConifguration {
	@Autowired
	private BearerTokenInterceptor authInterceptor;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.additionalInterceptors(authInterceptor)
				.build();
	}

	public BearerTokenInterceptor getAuthInterceptor() {
		return authInterceptor;
	}

	public void setAuthInterceptor(BearerTokenInterceptor authInterceptor) {
		this.authInterceptor = authInterceptor;
	}
}
