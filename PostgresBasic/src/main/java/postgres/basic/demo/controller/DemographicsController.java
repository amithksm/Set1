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

import postgres.basic.demo.dto.DemographicsDTO;
import postgres.basic.demo.entity.DemographicsEntity;
import postgres.basic.demo.service.DemographicsService;

@RestController
@RequestMapping("/api")
public class DemographicsController {

	@Autowired
	DemographicsService demogService;
	
	@PostMapping("/students/{id}/demographics")
	public DemographicsEntity addAddressById(@Valid @RequestBody DemographicsDTO address, @PathVariable Long id) {
		return demogService.saveAddressById(id , address);
	}
	
	@PostMapping("/students/student/{roll-num}")
	public DemographicsEntity addAddressByRollNum(@Valid @RequestBody DemographicsDTO address, @PathVariable("roll-num") Integer rollNum) {
		return demogService.saveAddressByRollNum(rollNum , address);
	}
	
	@GetMapping("/students/{id}/demographics")
	public List<DemographicsEntity> studentAddressById(@PathVariable("id") Long id){
		return demogService.getAddressByStudentId(id);
	}
	
	@GetMapping("/students/student/{roll-num}/demographics")
	public List<DemographicsEntity> studentAddressByRollNum(@PathVariable("roll-num") Integer rollNum){
		return demogService.getAddressByStudentRollNum(rollNum);
	}
	
	@GetMapping("/demographics/{id}")
	public DemographicsEntity addressByDemogId(@PathVariable("id") Long id){
		return demogService.addressByDemogId(id);
	}
}
