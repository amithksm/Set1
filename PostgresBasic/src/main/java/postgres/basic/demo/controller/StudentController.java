package postgres.basic.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postgres.basic.demo.dto.StudentDTO;
import postgres.basic.demo.entity.StudentEntity;
import postgres.basic.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public StudentEntity registerStudent(@Valid @RequestBody StudentDTO student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/students")
	public List<StudentEntity> listStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public StudentEntity getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/students/student/{roll-num}")
	public StudentEntity getStudentByRollNum(@PathVariable("roll-num") Integer id){
		return studentService.getStudentByRollNum(id);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
	

}
