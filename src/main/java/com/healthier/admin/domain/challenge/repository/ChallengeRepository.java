package com.healthier.admin.domain.challenge.repository;

import com.healthier.admin.domain.challenge.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {}
