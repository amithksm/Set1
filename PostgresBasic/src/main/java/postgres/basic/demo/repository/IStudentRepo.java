package postgres.basic.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import postgres.basic.demo.entity.StudentEntity;

@Repository
public interface IStudentRepo extends CrudRepository<StudentEntity, Long>{
	
	List<StudentEntity> findAll();
	Optional<StudentEntity> findByRollNum(Integer rollNum);

}
