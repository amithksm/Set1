package com.example.demo.controller;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.controller.DuckController;
import com.example.demo.duck.ColorEnum;
import com.example.demo.duck.Duck;
import com.example.demo.duck.DuckEnum;
import com.example.demo.duck.FlyNoWay;
import com.example.demo.duck.FlyWithWings;
import com.example.demo.duck.MallardDuck;
import com.example.demo.duck.RubberDuck;
import com.example.demo.service.DuckService;

@WebMvcTest(DuckController.class)
public class DuckControllerTest {
	
	@MockBean
	DuckService duckService;
	
	@Autowired
	MockMvc mockMvc;
	
	Duck mallardDuck;
	Duck rubberDuck;
	
	@BeforeEach
	void setMallard() {
		mallardDuck = new MallardDuck();
		mallardDuck.setColor(ColorEnum.BLUE);
		mallardDuck.setDuckType(DuckEnum.MALLARD);
		mallardDuck.setFlyBehaviour(new FlyWithWings());
		mallardDuck.setSize(5);
		mallardDuck.setDuckId(Long.valueOf(44));
	}
	
	@AfterEach
	void tearDown() {
		reset(duckService);
	}

	@Test
	@DisplayName("getDuck() - positive case")
	public void testGetDuck() throws Exception  {
		
		given(duckService.getDuckById(any())).willReturn(mallardDuck);
		
		mockMvc.perform(get("/api/ducks/" + mallardDuck.getDuckId()))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.color", is("BLUE")))
				.andExpect(jsonPath("$.duckType", is("MALLARD")))
				.andExpect(jsonPath("$.duckId", is(Integer.valueOf(44))))
				.andExpect(jsonPath("$.size").value(mallardDuck.getSize()))
				.andReturn();
	}
	
	@Test
	@DisplayName("getDuck() - duck not found")
	public void testGetDuckNull() throws Exception  {
		
		given(duckService.getDuckById(any())).willReturn(null);
		mockMvc.perform(get("/api/ducks/" + "33"))
								.andExpect(status().isNotFound())
								.andExpect(jsonPath("$").doesNotExist())
								.andDo(print())
								.andReturn();
	}
	
	@DisplayName("DuckControllerTest - List Operations")
	@Nested
	public class TestListOperations{
		
		List<Duck> duckList;
		
		@BeforeEach
		void prepareList() {
			
			duckList = new ArrayList<>();
			
			rubberDuck = new RubberDuck();
			rubberDuck.setColor(ColorEnum.RED);
			rubberDuck.setDuckType(DuckEnum.RUBBER);
			rubberDuck.setFlyBehaviour(new FlyNoWay());
			rubberDuck.setSize(10);
			rubberDuck.setDuckId(Long.valueOf(55));
			
			duckList.add(mallardDuck);
			duckList.add(rubberDuck);
		}
		
		@Test
		@DisplayName("getAllDucks()")
		public void testGetAllDucks() throws Exception {
			
			given(duckService.getAll()).willReturn(duckList);
			
			mockMvc.perform(get("/api/ducks"))
					.andExpect(status().isOk())
					.andDo(print())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$", hasSize(2)))
					.andExpect(jsonPath("$.[0].duckType", is("MALLARD")))
					.andExpect(jsonPath("$.[0].color", is("BLUE")))
					.andExpect(jsonPath("$.[0].duckId", is(Integer.valueOf(mallardDuck.getDuckId().toString()))))
					.andExpect(jsonPath("$.[1].duckType", is("RUBBER")))
					.andExpect(jsonPath("$.[1].duckId").value(55))
					.andExpect(jsonPath("$.[1].color", is("RED")))
					.andReturn();
		}
		
		@Test
		@DisplayName("getAllDucks() - no ducks")
		public void testGetAllDucksNoDucks() throws Exception {
			
			duckList.clear();
			given(duckService.getAll()).willReturn(duckList);
			
			mockMvc.perform(get("/api/ducks"))
					.andExpect(status().isOk())
					.andDo(print())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$", hasSize(0)))
					.andReturn();
		}
	}
}
