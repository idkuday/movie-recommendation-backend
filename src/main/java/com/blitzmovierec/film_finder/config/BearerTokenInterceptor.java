package com.blitzmovierec.film_finder.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class BearerTokenInterceptor implements ClientHttpRequestInterceptor {
    @Value("${tmdb.api.key}")
    private String API_KEY;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        try {
	        request.getHeaders().setBearerAuth(API_KEY);
	        return execution.execute(request, body);
        }
        catch(HttpClientErrorException e) {
        	throw new RuntimeException("API call failed due to Client Error : "+ e);
        }
        catch(Exception e) {
        	throw new RuntimeException("API call failed due to an unexpected exception : " + e);
        }
    }
}