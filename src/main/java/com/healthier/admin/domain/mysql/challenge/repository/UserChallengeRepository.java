package com.healthier.admin.domain.mysql.challenge.repository;

import com.healthier.admin.domain.mysql.challenge.domain.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {}
