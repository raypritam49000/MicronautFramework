package com.rest.jwt.api.repositories;

import com.rest.jwt.api.entities.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.data.repository.PageableRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends CrudRepository<User, Long>, PageableRepository<User,Long>, GenericRepository<User,Long> {
    Optional<User> findByName(String name);
}

