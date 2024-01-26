package com.healthier.admin.domain.advertisement.service;

import com.healthier.admin.domain.advertisement.domain.AdLocation;
import com.healthier.admin.domain.advertisement.domain.Advertisement;
import com.healthier.admin.domain.advertisement.dto.AdvertisementDto;
import com.healthier.admin.domain.advertisement.repository.AdvertisementRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;

    // Create Advertisement
    @Transactional
    public void createAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = Advertisement.fromAdvertisementDto(advertisementDto);
        advertisementRepository.save(advertisement);
    }

    // Get All Advertisements
    public List<AdvertisementDto> getAllAdvertisements() {
        return advertisementRepository.findAll().stream()
                .map(AdvertisementDto::fromPreview)
                .collect(Collectors.toList());
    }

    // Get Advertisement by ID
    public AdvertisementDto getAdvertisement(Long id) {
        return advertisementRepository
                .findById(id)
                .map(AdvertisementDto::fromDetail)
                .orElseThrow(() -> new IllegalArgumentException("해당 광고가 존재하지 않습니다."));
    }

    // Update Advertisement
    @Transactional
    public void updateAdvertisement(Long id, AdvertisementDto advertisementDto) {
        Advertisement updatedAdvertisement =
                advertisementRepository
                        .findById(id)
                        .map(
                                advertisement -> {
                                    advertisement.updateAdvertisement(
                                            advertisementDto.getStartDate(),
                                            advertisementDto.getEndDate(),
                                            advertisementDto.getAdvertiser(),
                                            advertisementDto.getTitle(),
                                            advertisementDto.getSubtitle(),
                                            advertisementDto.getImage(),
                                            AdLocation.fromString(advertisementDto.getLocation()),
                                            advertisementDto.getUrl());
                                    return advertisement;
                                })
                        .orElseThrow(() -> new IllegalArgumentException("해당 광고가 존재하지 않습니다."));

        advertisementRepository.save(updatedAdvertisement);
    }

    // Update Advertisement isPublished
    @Transactional
    public void updateAdvertisementIsPublished(Long id, AdvertisementDto advertisementDto) {
        Advertisement updatedAdvertisement =
                advertisementRepository
                        .findById(id)
                        .map(
                                advertisement -> {
                                    advertisement.updateAdvertisementIsPublished(
                                            advertisementDto.isPublished());
                                    return advertisement;
                                })
                        .orElseThrow(() -> new IllegalArgumentException("해당 광고가 존재하지 않습니다."));

        advertisementRepository.save(updatedAdvertisement);
    }
}
