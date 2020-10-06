package postgres.basic.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.basic.demo.entity.ContactEntity;

@Repository
public interface IContactRepo extends CrudRepository<ContactEntity, Long>{
	
	List<ContactEntity> findByMobileNum(String mobileNum);

}
