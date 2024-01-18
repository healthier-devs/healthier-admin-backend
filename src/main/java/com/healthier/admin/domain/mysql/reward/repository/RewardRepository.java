package com.healthier.admin.domain.mysql.reward.repository;

import com.healthier.admin.domain.mysql.reward.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {}
