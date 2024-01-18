package com.healthier.admin.domain.mysql.reward.repository;

import com.healthier.admin.domain.mysql.reward.domain.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRewardRepository extends JpaRepository<UserReward, Long> {}
