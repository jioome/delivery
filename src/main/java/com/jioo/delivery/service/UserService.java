package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.UserRequest;
import com.jioo.delivery.oauth.User;
import com.jioo.delivery.oauth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private final List<User> users = new ArrayList<>();

// create 없이 delete update read 만 있어도 됨
//    public User create(UserRequest userParameter) {
//        final User user = new User(userParameter.getId(), userParameter.getEmail(), userParameter.getPicture(), userParameter.getRole(), userParameter.getPhoneNumber(),userParameter.getAddress());
////        return userRepository.save(user);
//        return user;
//    }

    public User read(Long id) {
//        return userRepository.findById(id).orElseThrow(NullPointerException::new);
        return null;
    }

//
//    public void delete(Long id) {
//        users.removeIf(restaurant -> Objects.equals(restaurant.getId(), id));
//    }
}
