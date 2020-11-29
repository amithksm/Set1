package com.example.demo.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import com.example.demo.duck.FlyWithWings;
import com.example.demo.duck.MallardDuck;
import com.example.demo.service.DuckService;

@WebMvcTest(DuckController.class)
public class DuckControllerTest {
	
	@MockBean
	DuckService duckService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
    WebApplicationContext wac;
	
	Duck mallardDuck;
	
	@BeforeEach
	void setMallard() {
		mallardDuck = new MallardDuck();
		mallardDuck.setColor(ColorEnum.BLUE);
		mallardDuck.setDuckType(DuckEnum.MALLARD);
		mallardDuck.setFlyBehaviour(new FlyWithWings());
		mallardDuck.setSize(500);
		mallardDuck.setDuckId(Long.valueOf(44));
	}
	
	@AfterEach
	void tearDown() {
		reset(duckService);
	}

	@Test
	@DisplayName("DuckControllerTest")
	public void testGetDuck() throws Exception  {
		
		given(duckService.getDuckById(any())).willReturn(mallardDuck);
		
		MvcResult result = mockMvc.perform(get("/api/ducks/" + mallardDuck.getDuckId()))
								.andExpect(status().isOk())
								.andDo(print())
								.andExpect(content().contentType(MediaType.APPLICATION_JSON))
								.andExpect(jsonPath("$.color", is("BLUE")))
								.andExpect(jsonPath("$.duckType", is("MALLARD")))
								.andExpect(jsonPath("$.duckId").value(44))
								.andExpect(jsonPath("$.size").value(mallardDuck.getSize()))
								.andReturn();
		
		System.out.println("Finally something is happening"+result);
	}
}
