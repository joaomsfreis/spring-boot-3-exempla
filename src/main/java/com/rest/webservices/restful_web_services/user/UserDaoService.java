package com.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.webservices.restful_web_services.jpa.entity.User;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "João", LocalDate.now().minusYears(30)));
        users.add(new User(3, "Marcos", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
