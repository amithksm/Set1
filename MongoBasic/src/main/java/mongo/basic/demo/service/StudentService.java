package mongo.basic.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo.basic.demo.DTO.StudentDTO;
import mongo.basic.demo.Entity.DemographicsEntity;
import mongo.basic.demo.Entity.ProfileEntity;
import mongo.basic.demo.Entity.StudentEntity;
import mongo.basic.demo.repository.IDemographics;
import mongo.basic.demo.repository.IStudent;

@Service
public class StudentService {
	
	@Autowired
	IDemographics demoRepo;
	
	@Autowired
	IStudent studentRepo;
	
	public void saveStudent(StudentDTO student) {
		
		StudentEntity newStudent = new StudentEntity();
		ProfileEntity profile = new ProfileEntity();
		DemographicsEntity demographics = new DemographicsEntity();
		
		profile.setAge(student.getAge());
		profile.setGender(student.getGender());
		demographics.setAddress1(student.getAddress1());
		demographics.setAddress2(student.getAddress2());
		
		newStudent.setfName(student.getfName());
		newStudent.setlName(student.getlName());
		newStudent.setProfile(profile);
		newStudent.setDemographics(demographics);
		
		demoRepo.save(demographics);
		studentRepo.save(newStudent);
		
	}


}
