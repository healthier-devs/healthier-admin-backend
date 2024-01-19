package com.healthier.admin.domain.user.repository;

import com.healthier.admin.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
