package mongo.basic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import mongo.basic.demo.DTO.StudentDTO;
import mongo.basic.demo.service.StudentService;

@RestController
@Api
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping()
	public void register(@RequestBody StudentDTO student) {
		studentService.saveStudent(student);
	}

}
