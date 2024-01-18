package com.healthier.admin.domain.mysql.challenge.repository;

import com.healthier.admin.domain.mysql.challenge.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {}
