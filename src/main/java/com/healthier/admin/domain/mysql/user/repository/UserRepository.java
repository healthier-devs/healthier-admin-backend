package com.healthier.admin.domain.mysql.user.repository;

import com.healthier.admin.domain.mysql.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
