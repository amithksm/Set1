package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.example.demo.duck.Duck;

@SpringBootTest
public class DuckControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("DuckControllerTest")
	public void testGetDuck() throws RestClientException, MalformedURLException {
		
		ResponseEntity<Duck> response = restTemplate.getForEntity(new URL("http://localhost:" + 8181 + "/").toString(), Duck.class);
		assertEquals("", response.getBody());
	}
}
