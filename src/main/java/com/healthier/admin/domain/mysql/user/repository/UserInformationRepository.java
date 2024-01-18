package com.healthier.admin.domain.mysql.user.repository;

import com.healthier.admin.domain.mysql.user.domain.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {}
