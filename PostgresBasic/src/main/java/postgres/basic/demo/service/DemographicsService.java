package postgres.basic.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgres.basic.demo.NotFoundException;
import postgres.basic.demo.dto.DemographicsDTO;
import postgres.basic.demo.entity.DemographicsEntity;
import postgres.basic.demo.repository.IDemographicsRepo;
import postgres.basic.demo.repository.IStudentRepo;

@Service
public class DemographicsService {
	
	@Autowired
	IStudentRepo studentRepo;
	
	@Autowired
	IDemographicsRepo demogRepo;
	
	public DemographicsEntity saveAddress(Long studentId, DemographicsDTO address){
		
		if(studentRepo.findById(studentId).isPresent()) {
			DemographicsEntity newAddress = new DemographicsEntity();
			newAddress.setAddress1(address.getAddress1());
			newAddress.setAddress2(address.getAddress2());
			newAddress.setPincode(address.getPinCode());
			newAddress.setStudent(studentRepo.findById(studentId).get());
			return demogRepo.save(newAddress);
		}
		throw new NotFoundException("Student not found with id "+studentId);
		
	}

	public List<DemographicsEntity> getAddress(Long studentId) {
		return (List<DemographicsEntity>) demogRepo.findByStudentId(studentId);
	}

	public DemographicsEntity addressByDemogId(Long id) {
		if(demogRepo.findById(id).isPresent())
			return demogRepo.findById(id).get();
		throw new NotFoundException("Demographics details not found for id "+ id);
	}
}