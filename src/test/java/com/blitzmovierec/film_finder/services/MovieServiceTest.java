package com.blitzmovierec.film_finder.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class) 
public class MovieServiceTest {
	@Mock
	protected RestTemplate restTemplate;
	
	@InjectMocks
	protected MovieService classUnderTest;
	
	
	@Test
	public void successfulSearch() {
		String expectedResponse = "{ \"results\": [ { \"title\": \"Inception\" } ] }";
		doReturn(expectedResponse).when(restTemplate).getForObject(anyString(), eq(String.class));
		String actualResponse = classUnderTest.searchMovieByName("Inception");
		assertNotNull(actualResponse);
        assertTrue(actualResponse.contains("Inception"));
	}
	
	
}
