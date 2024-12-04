package com.rest.webservices.restful_web_services.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restful_web_services.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
