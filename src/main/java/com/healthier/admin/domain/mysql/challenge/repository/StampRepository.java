package com.healthier.admin.domain.mysql.challenge.repository;

import com.healthier.admin.domain.mysql.challenge.domain.Stamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StampRepository extends JpaRepository<Stamp, Long> {}
