package postgres.basic.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postgres.basic.demo.dto.ContactDTO;
import postgres.basic.demo.entity.ContactEntity;
import postgres.basic.demo.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@PostMapping("/students/{roll-num}/contactInfo")
	public ContactEntity addContactInfo(@Valid @RequestBody ContactDTO contactInfo, @PathVariable("roll-num") Integer rollNum) {
		return contactService.addContactNumber(contactInfo, rollNum);
	}
	
	@GetMapping("/contactInfo/{mobile}")
	public List<ContactEntity> getContactDetails(@PathVariable("mobile") String mobile) {
		return contactService.getContactInfo(mobile);
	}
	
	@GetMapping("/contacts/contactInfo/{id}")
	public ContactEntity getContactById(@PathVariable("id") Long id) {
		return contactService.getContactById(id);
	}

}
