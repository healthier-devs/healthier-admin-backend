package com.healthier.admin.domain.reward.repository;

import com.healthier.admin.domain.reward.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {}
