package postgres.basic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postgres.basic.demo.dto.UserDTO;
import postgres.basic.demo.entity.UserEntity;
import postgres.basic.demo.service.UserService;
import postgres.basic.demo.service.UserServiceTransactional;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceTransactional userServiceTransactional;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users/non-transactional")
	public void registerUser(@RequestBody UserDTO user) {
		userService.addUser(user);
	}
	
	@PostMapping("/users/transactional")
	public void registerUserTransactional(@RequestBody UserDTO user) {
		userServiceTransactional.addUser(user);
	}
	
	@PostMapping("/users/transactional-demo")
	public void registerUserTransactional() {
		
		//This api will throw an exception when uname is "amithksm". The "user" table and "profile" table will not be committed to DB
		UserDTO user = new UserDTO();
		user.setAge(100);
		user.setFName("Amith");
		user.setLName("Kumar");
		user.setPassword("*#JUD7");
		user.setUName("amithksm");
		
		userServiceTransactional.addUser(user);
	}
	
	@PostMapping("/users/non-transactional-demo")
	public void registerUserNonTransactional() {
		
		//The "user" table will be saved with user info. While the "profile" table will not be committed to DB
		UserDTO user = new UserDTO();
		user.setAge(100);
		user.setFName("Amith");
		user.setLName("Kumar");
		user.setPassword("*#JUD7");
		user.setUName("amithksm");
		
		userServiceTransactional.addUser(user);
	}
	
	@GetMapping("/users")
	public List<UserEntity> listAllUsers() {
		return userService.getAll();
	}
	
	@DeleteMapping("/users")
	public String deleteAllUsers() {
		userService.deleteUsers();
		return "All users deleted";
	}
	
	@GetMapping("/users/{uname}")
	public UserEntity getUserByUname(@PathVariable("uname") String uname) {
		return userService.findUserByUname(uname);
	}

}
