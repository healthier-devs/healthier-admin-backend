package com.healthier.admin.domain.reward.repository;

import com.healthier.admin.domain.reward.domain.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRewardRepository extends JpaRepository<UserReward, Long> {}