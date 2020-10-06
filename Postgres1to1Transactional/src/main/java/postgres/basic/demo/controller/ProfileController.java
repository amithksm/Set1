package postgres.basic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postgres.basic.demo.repository.IUserProfileRepository;

@RestController
@RequestMapping("/api")
public class ProfileController {
	
	@Autowired
	IUserProfileRepository profileRepo;
	
	@DeleteMapping("/profiles")
	public String deleteAllProfiles() {
		profileRepo.deleteAll();
		return "All users profiles deleted";
	}

}
