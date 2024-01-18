package com.healthier.admin.domain.mysql.user.repository;

import com.healthier.admin.domain.mysql.user.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {}
