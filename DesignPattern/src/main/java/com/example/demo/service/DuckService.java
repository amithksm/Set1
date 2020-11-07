package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DuckDTO;
import com.example.demo.duck.Duck;
import com.example.demo.duck.FlyEnum;
import com.example.demo.duck.FlyNoWay;
import com.example.demo.duck.FlyWithWings;
import com.example.demo.entity.DuckEntity;
import com.example.demo.factory.DuckGenerator;
import com.example.demo.repository.IDuckRepository;

@Service
public class DuckService {

	@Autowired
	DuckGenerator duckGenerator;

	@Autowired
	IDuckRepository duckRepo;

	public DuckEntity saveDuck(DuckDTO duck) {

		DuckEntity duckEntity = new DuckEntity();
		duckEntity.setColor(duck.getColor());
		duckEntity.setSize(duck.getSize());
		duckEntity.setDuck(duck.getDuckType());
		duckRepo.save(duckEntity);

		return duckEntity;
	}

	public List<DuckEntity> getAll() {

		List<DuckEntity> allDucks = new ArrayList<>();
		duckRepo.findAll().forEach(allDucks::add);
		return allDucks;

	}

	public ResponseEntity<Duck> getById(Long id) {
		Duck duck = getDuckById(id);
		if (duck != null) {
			return ResponseEntity.status(HttpStatus.OK).body(duck);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public Duck getDuckById(Long id) {
		Optional<DuckEntity> duck = duckRepo.findById(id);
		if (duck.isPresent()) {
			Duck newDuck = duckGenerator.generateDuck(duck.get().getDuck());
			newDuck.setColor(duck.get().getColor());
			newDuck.setSize(duck.get().getSize());
			return newDuck;
		}
		return null;
	}

	public ResponseEntity<String> changeFly(Long id, FlyEnum behaviour) {
		Duck newDuck = getDuckById(id);

		if (newDuck != null) {
			switch (behaviour) {
			case NOFLY:
				newDuck.setFlyBehaviour(new FlyNoWay());
				return ResponseEntity.status(HttpStatus.OK).body(newDuck.performFly());
			case WINGS:
				newDuck.setFlyBehaviour(new FlyWithWings());
				return ResponseEntity.status(HttpStatus.OK).body(newDuck.performFly());
			default:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid behaviour input");
			}
		}
		throw new NoSuchElementException("Duck with id " + id + " not found");
	}

	public ResponseEntity<Duck> deleteDuck(Long id) {
		
		Duck newDuck = getDuckById(id);
		if(newDuck != null) {
			duckRepo.deleteById(id);
			return new ResponseEntity<>(newDuck, HttpStatus.OK);
		}	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> flyAduck(Long id) {
		Duck newDuck = getDuckById(id);
		if(newDuck != null) {
			return new ResponseEntity<>(newDuck.performFly(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
