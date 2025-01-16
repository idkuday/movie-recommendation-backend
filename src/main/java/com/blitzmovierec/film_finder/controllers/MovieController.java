package com.blitzmovierec.film_finder.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzmovierec.film_finder.services.MovieService;

@RestController()
@RequestMapping("/api/movies")
public class MovieController {
	private final MovieService movieService;	

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{query}")
	public ResponseEntity<String> searchByMovieName(@PathVariable String query) {
			return ResponseEntity.ok(movieService.searchMovieByName(query));
	}
}
