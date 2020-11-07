package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DuckEntity;

@Repository
public interface IDuckRepository extends CrudRepository<DuckEntity, Long>{

}
