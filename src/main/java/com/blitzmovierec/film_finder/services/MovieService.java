package com.blitzmovierec.film_finder.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
	@Value("${tmdb.api.baseUrl}")
	private String BASE_URL;
	
	private final RestTemplate restTemplate;
	
	public MovieService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String searchMovieByName(String searchString) {
		String url = String.format("%s/search/movie?include_adult=true&query=%s", BASE_URL, searchString);
		return restTemplate.getForObject(url, String.class);
	}
}
