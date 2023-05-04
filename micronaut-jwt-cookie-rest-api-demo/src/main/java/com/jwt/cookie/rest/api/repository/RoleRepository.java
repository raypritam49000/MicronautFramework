package com.jwt.cookie.rest.api.repository;


import com.jwt.cookie.rest.api.entity.Role;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
