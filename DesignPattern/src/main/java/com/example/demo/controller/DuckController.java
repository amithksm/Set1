package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DuckDTO;
import com.example.demo.duck.Duck;
import com.example.demo.duck.FlyEnum;
import com.example.demo.duck.FlyNoWay;
import com.example.demo.entity.DuckEntity;
import com.example.demo.service.DuckService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api
public class DuckController {
	
	@Autowired
	DuckService duckService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/ducks")
	public ResponseEntity<DuckEntity> createDuck(@RequestBody @Valid DuckDTO duck) {
		DuckEntity newDuck = duckService.saveDuck(duck);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDuck);
	}
	
	@GetMapping("/ducks")
	public List<Duck> getAllDucks() {
		
		return duckService.getAll();
	}
	
	@GetMapping("/ducks/{id}")
	public ResponseEntity<Duck>  getDuck(@PathVariable Long id) {
		Duck duck = duckService.getDuckById(id);
		if(duck != null)
			return ResponseEntity.status(HttpStatus.OK).body(duck);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}
	
	@DeleteMapping("/ducks/{id}")
	public ResponseEntity<Duck>  deleteDuck(@PathVariable Long id) {
		return duckService.deleteDuck(id);
	}
	
	@GetMapping("/ducks/{id}/fly")
	public ResponseEntity<String> flyAduck(@PathVariable Long id) {
		return duckService.flyAduck(id);
	}
	
	@GetMapping("/ducks/{id}/fly/{behaviour}")
	public ResponseEntity<String> changeFlyBehaviour(@PathVariable("id") Long id, @PathVariable("behaviour") FlyEnum behaviour) {
		// Custom Exception Handling
		return duckService.changeFly(id, behaviour);
	}
	

}
