package com.mongodb.rest.api.repository;

import com.mongodb.rest.api.entity.Person;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.PageableRepository;

@MongoRepository
public interface PersonRepository extends PageableRepository<Person,String> {
}
