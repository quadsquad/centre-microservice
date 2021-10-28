package com.centre.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centre.app.entities.Centre;

@Repository
public interface CentreRepository extends MongoRepository<Centre, String> {

}
