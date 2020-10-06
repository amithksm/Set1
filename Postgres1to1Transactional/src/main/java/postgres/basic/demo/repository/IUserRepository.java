package postgres.basic.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.basic.demo.entity.UserEntity;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByuName(String uname);

}
