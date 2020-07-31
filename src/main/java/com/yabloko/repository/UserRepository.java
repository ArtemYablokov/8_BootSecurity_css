package com.yabloko.repository;

import com.yabloko.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLogin(String login);
}