package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.UserRequest;
import com.jioo.delivery.oauth.Role;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.oauth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final List<User> users = new ArrayList<>();
    private String id;

    // create 없이 delete update read 만 있어도 됨
    public User create(UserRequest userParameter) {
        final User user = new User(userParameter.getId(), userParameter.getName(), userParameter.getEmail(), userParameter.getPicture(), userParameter.getRole(), userParameter.getUserId());
        return userRepository.save(user);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Cacheable(cacheNames = "user", key = "#id") // key = #id?
    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}