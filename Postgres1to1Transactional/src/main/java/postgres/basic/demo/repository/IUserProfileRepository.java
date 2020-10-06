package postgres.basic.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.basic.demo.entity.UserProfileEntity;

@Repository
public interface IUserProfileRepository extends CrudRepository<UserProfileEntity, Long> {

}
