package com.healthier.admin.domain.user.repository;

import com.healthier.admin.domain.user.domain.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {}
