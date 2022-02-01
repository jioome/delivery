package com.jioo.delivery.repository;

import com.jioo.delivery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
