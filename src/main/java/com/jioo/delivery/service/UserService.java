package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.UserRequest;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.domain.User;
import com.jioo.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private final List<User> users = new ArrayList<>();


    public User create(UserRequest userParameter) {
        final User user = new User(userParameter.getUserId(), userParameter.getAddress(), userParameter.getName(), userParameter.getPhoneNumber(), userParameter.getType());
        return userRepository.save(user);
    }

    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

//
//    public void delete(Long id) {
//        users.removeIf(restaurant -> Objects.equals(restaurant.getId(), id));
//    }
}
