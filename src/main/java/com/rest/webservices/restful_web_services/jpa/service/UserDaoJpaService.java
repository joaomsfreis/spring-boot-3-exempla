package com.rest.webservices.restful_web_services.jpa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rest.webservices.restful_web_services.jpa.entity.Post;
import com.rest.webservices.restful_web_services.jpa.entity.User;
import com.rest.webservices.restful_web_services.jpa.repository.PostRepository;
import com.rest.webservices.restful_web_services.jpa.repository.UserRepository;
import com.rest.webservices.restful_web_services.user.UserNotFoundException;

@Service
public class UserDaoJpaService {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserDaoJpaService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Integer id) {
        var foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        return foundUser.get();
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        var createdUser = userRepository.save(user);
        return createdUser;
    }

    public List<Post> getPostsByUser(Integer id) {
        User user = findOne(id);
        return user.getPosts();
    }

    public Post savePost(Integer userId, Post post) {
        User user = findOne(userId);
        post.setUser(user);

        return postRepository.save(post);
    }

    public Post getPostsById(Integer id) {
        var foundPost = postRepository.findById(id);

        if (foundPost.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        return foundPost.get();
    }
}
