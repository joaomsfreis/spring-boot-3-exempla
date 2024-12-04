package com.rest.webservices.restful_web_services.jpa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_services.jpa.entity.Post;
import com.rest.webservices.restful_web_services.jpa.entity.User;
import com.rest.webservices.restful_web_services.jpa.service.UserDaoJpaService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserJpaController {

    private UserDaoJpaService service;

    public UserJpaController(UserDaoJpaService service) {
        this.service = service;
    }

    @GetMapping("/jpa/users")
    public List<User> getUsers() {
        return service.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable Integer id) {
        User user = service.findOne(id);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable Integer id) {
        return service.getPostsByUser(id);
    }
    
    @GetMapping("/jpa/posts/{id}")
    public Post getPostsByUserAndId(@PathVariable Integer id) {
        return service.getPostsById(id);
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<User> createPost(@PathVariable Integer id, @Valid @RequestBody Post post) {
        Post createdPost = service.savePost(id, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id, createdPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
