package mongo.basic.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mongo.basic.demo.Entity.StudentEntity;

@Repository
public interface IStudent extends MongoRepository<StudentEntity, String>{

	
}
