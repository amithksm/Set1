package mongo.basic.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mongo.basic.demo.Entity.DemographicsEntity;

@Repository
public interface IDemographics extends MongoRepository<DemographicsEntity, String>{

}
