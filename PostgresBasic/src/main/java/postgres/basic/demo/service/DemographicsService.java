package postgres.basic.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
	
	public DemographicsEntity saveAddressById(Long studentId, DemographicsDTO address){
		
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

	public List<DemographicsEntity> getAddressByStudentId(Long studentId) {
		return (List<DemographicsEntity>) demogRepo.findByStudentId(studentId);
	}
	
	public List<DemographicsEntity> getAddressByStudentRollNum(Integer rollNum) {
		if(studentRepo.findByRollNum(rollNum).isPresent()) {
			Long id = studentRepo.findByRollNum(rollNum).get().getId();
			return getAddressByStudentId(id);
		}
		throw new NotFoundException("Student not found with roll num "+rollNum);
	}

	public DemographicsEntity addressByDemogId(Long id) {
		if(demogRepo.findById(id).isPresent())
			return demogRepo.findById(id).get();
		throw new NotFoundException("Demographics details not found for id "+ id);
	}

	public DemographicsEntity saveAddressByRollNum(Integer rollNum, @Valid DemographicsDTO address) {
		if(studentRepo.findByRollNum(rollNum).isPresent()) {
			DemographicsEntity newAddress = new DemographicsEntity();
			newAddress.setAddress1(address.getAddress1());
			newAddress.setAddress2(address.getAddress2());
			newAddress.setPincode(address.getPinCode());
			newAddress.setStudent(studentRepo.findByRollNum(rollNum).get());
			return demogRepo.save(newAddress);
		}
		throw new NotFoundException("Student not found with roll num "+rollNum);
	}

	public String deleteAllAddressOfStudent(Integer rollNum) {
		
		if(studentRepo.findByRollNum(rollNum).isPresent()) {
			Long studentId = studentRepo.findByRollNum(rollNum).get().getId();
			List<DemographicsEntity> addresses = new ArrayList<DemographicsEntity>();
			addresses.addAll(demogRepo.findByStudentId(studentId));
			for(DemographicsEntity de : addresses) {
				demogRepo.delete(de);
			}
			return "Address deleted successfully";
		}
		throw new NotFoundException("No address found for roll num "+rollNum);
	}

	public String deleteAddressByDemogId(Long demogId) {
		if(demogRepo.findById(demogId).isPresent()) {
			demogRepo.delete(demogRepo.findById(demogId).get());
			return "Student address deleted successfully";
		}
		throw new NotFoundException("Demographics details not found for demographics id "+ demogId);
	}

	
}
