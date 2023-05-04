package com.jwt.rest.api.repository;

import com.jwt.rest.api.entities.Role;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
