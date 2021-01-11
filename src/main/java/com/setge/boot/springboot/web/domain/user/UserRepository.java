package com.setge.boot.springboot.web.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // <Entity클래스, PK>

    // email이 null일 수도 있으므로, Optional 사용
    Optional<User> findByEmail(String email);
}
