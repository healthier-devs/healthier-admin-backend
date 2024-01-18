package com.healthier.admin.domain.mysql.advertisement.repository;

import com.healthier.admin.domain.mysql.advertisement.domain.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {}
