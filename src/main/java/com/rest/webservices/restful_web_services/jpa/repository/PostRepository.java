package com.rest.webservices.restful_web_services.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restful_web_services.jpa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
