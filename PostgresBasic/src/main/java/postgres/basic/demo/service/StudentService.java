package postgres.basic.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgres.basic.demo.NotFoundException;
import postgres.basic.demo.dto.StudentDTO;
import postgres.basic.demo.entity.StudentEntity;
import postgres.basic.demo.repository.IStudentRepo;

@Service
public class StudentService {
	
	@Autowired
	IStudentRepo studentRepo;

	public StudentEntity saveStudent(StudentDTO student) {
		
		StudentEntity newStudent = new StudentEntity();
		newStudent.setName(student.getName());
		newStudent.setGender(student.getGender());
		newStudent.setRollNum(student.getRollNum());
		
		return studentRepo.save(newStudent);
		
	}

	public List<StudentEntity> getAllStudents() {
		
		return studentRepo.findAll();
	}

	public StudentEntity getStudentById(Long id) {
		Optional<StudentEntity> student = studentRepo.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		
		 throw new NotFoundException("Student not found with id "+ id);
	}

	public String deleteStudent(Long id) {
		studentRepo.findById(id).map(student -> {
			studentRepo.delete(student);
			return "Student delete successfully";
		}).orElseThrow(() -> new NotFoundException("Student not found with id "+id));
		return null;
	}

	public StudentEntity getStudentByRollNum(Integer rollNum) {
		Optional<StudentEntity> student = studentRepo.findByRollNum(rollNum);
		
		if(student.isPresent())
			return student.get();
		throw new NotFoundException("Student not found with roll number "+rollNum);
	}

}
