package postgres.basic.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgres.basic.demo.NotFoundException;
import postgres.basic.demo.dto.ContactDTO;
import postgres.basic.demo.entity.ContactEntity;
import postgres.basic.demo.repository.IContactRepo;
import postgres.basic.demo.repository.IStudentRepo;

@Service
public class ContactService {

	@Autowired
	IContactRepo contactRepo;
	
	@Autowired
	IStudentRepo studentRepo;
	
	public ContactEntity addContactNumber(ContactDTO contact, Integer rollNum) {
		
		if(studentRepo.findByRollNum(rollNum).isPresent()) {
			ContactEntity ce = new ContactEntity();
			ce.setMobileNum(contact.getMobileNum());
			ce.setStudent(studentRepo.findByRollNum(rollNum).get());
			return contactRepo.save(ce);
		}throw new NotFoundException("Student details not found with roll num "+rollNum);
		
	}
	
}
