package com.healthier.admin.domain.user.repository;

import com.healthier.admin.domain.user.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {}
