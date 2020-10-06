package postgres.basic.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgres.basic.demo.dto.UserDTO;
import postgres.basic.demo.entity.UserEntity;
import postgres.basic.demo.entity.UserProfileEntity;
import postgres.basic.demo.repository.IUserProfileRepository;
import postgres.basic.demo.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IUserProfileRepository profileRepo;
	
	
	public void addUser(UserDTO user) {
		
		UserEntity newUser = new UserEntity();
		newUser.setUName(user.getUName());
		newUser.setPassword(user.getPassword());
		
		UserProfileEntity profile = new UserProfileEntity();
		profile.setAge(user.getAge());
		profile.setFName(user.getFName());
		profile.setLName(user.getLName());
		
		newUser.setUserProfile(profile);
		profile.setUser(newUser);
		
		userRepo.save(newUser);
		
		UserEntity amithksmUserName = userRepo.findByuName("amithksm");
		if(amithksmUserName != null && amithksmUserName.getUName().matches("amithksm")) {
			System.out.println("Erroring out to demo transactional");
			throw new RuntimeException("Erroring out to demo transactional");
		}
		
		profileRepo.save(profile);
		
	}


	public List<UserEntity> getAll() {
		
		List<UserEntity> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}


	public void deleteUsers() {
		
		userRepo.deleteAll();
	}
	
	public UserEntity findUserByUname(String uname) {
		return userRepo.findByuName(uname);
	}
	

}
