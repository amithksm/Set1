package postgres.basic.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.basic.demo.entity.DemographicsEntity;

@Repository
public interface IDemographicsRepo extends CrudRepository<DemographicsEntity, Long>{
	
	List<DemographicsEntity> findByStudentId(Long studentId);

}
