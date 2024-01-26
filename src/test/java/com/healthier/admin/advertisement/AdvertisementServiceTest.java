package com.healthier.admin.advertisement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.healthier.admin.domain.advertisement.domain.AdLocation;
import com.healthier.admin.domain.advertisement.domain.Advertisement;
import com.healthier.admin.domain.advertisement.dto.AdvertisementDto;
import com.healthier.admin.domain.advertisement.repository.AdvertisementRepository;
import com.healthier.admin.domain.advertisement.service.AdvertisementService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @Mock private AdvertisementRepository advertisementRepository;

    @InjectMocks private AdvertisementService advertisementService;

    private Advertisement advertisement1, advertisement2;
    private AdvertisementDto advertisementDto1, advertisementDto2;

    @BeforeEach
    void setUp() {
        advertisement1 =
                Advertisement.builder()
                        .id(1L)
                        .startDate(LocalDateTime.parse("2021-09-01T00:00"))
                        .endDate(LocalDateTime.parse("2021-09-30T23:59"))
                        .advertiser("광고주1")
                        .title("광고 제품1")
                        .subtitle("광고 제품1 서브 타이틀")
                        .image("광고 제품1 이미지")
                        .location(AdLocation.valueOf("MAIN_HOME"))
                        .url("광고 제품1 링크")
                        .isPublished(true)
                        .build();

        advertisement2 =
                Advertisement.builder()
                        .id(2L)
                        .startDate(LocalDateTime.parse("2021-09-01T00:00"))
                        .endDate(LocalDateTime.parse("2021-09-30T23:59"))
                        .advertiser("광고주2")
                        .title("광고 제품2")
                        .subtitle("광고 제품2 서브 타이틀")
                        .image("광고 제품2 이미지")
                        .location(AdLocation.valueOf("CHALLENGE"))
                        .url("광고 제품2 링크")
                        .isPublished(true)
                        .build();

        advertisementDto1 =
                AdvertisementDto.builder()
                        .startDate(LocalDateTime.parse("2021-09-01T00:00"))
                        .endDate(LocalDateTime.parse("2021-09-30T23:59"))
                        .advertiser("광고주1")
                        .title("광고 제품1")
                        .subtitle("광고 제품1 서브 타이틀")
                        .image("광고 제품1 이미지")
                        .location("메인 홈")
                        .url("광고 제품1 링크")
                        .build();

        advertisementDto2 = AdvertisementDto.builder().isPublished(true).build();
    }

    @DisplayName("광고 전체 조회")
    @Test
    void getAllAdvertisementsTest() {
        // Given
        when(advertisementRepository.findAll())
                .thenReturn(Arrays.asList(advertisement1, advertisement2));

        // When
        List<AdvertisementDto> result = advertisementService.getAllAdvertisements();

        // Then
        assertEquals(2, result.size());

        assertTrue(result.stream().anyMatch(dto -> dto.getId().equals(advertisement1.getId())));
        assertTrue(result.stream().anyMatch(dto -> dto.getId().equals(advertisement2.getId())));
    }

    @DisplayName("광고 개별 조회")
    @Test
    void getAdvertisementTest() {
        // Given
        Long id = 1L;
        when(advertisementRepository.findById(id))
                .thenReturn(java.util.Optional.of(advertisement1));

        // When
        AdvertisementDto result = advertisementService.getAdvertisement(id);

        // Then
        assertNotNull(result);
        assertEquals(advertisement1.getId(), result.getId());
        assertEquals(advertisement1.getAdvertiser(), result.getAdvertiser());
        assertEquals(advertisement1.getTitle(), result.getTitle());
        assertEquals(advertisement1.getSubtitle(), result.getSubtitle());
        assertEquals(advertisement1.getImage(), result.getImage());
        assertEquals(advertisement1.getLocation().getName(), result.getLocation());
        assertEquals(advertisement1.getUrl(), result.getUrl());
        assertEquals(advertisement1.isPublished(), result.isPublished());
    }

    @DisplayName("광고 수정")
    @Test
    void updateAdvertisementTest() {
        // Given
        Long id = 1L;
        when(advertisementRepository.findById(id))
                .thenReturn(java.util.Optional.of(advertisement1));

        // When
        advertisementService.updateAdvertisement(id, advertisementDto1);

        // Then
        assertEquals(advertisement1.getAdvertiser(), advertisementDto1.getAdvertiser());
        assertEquals(advertisement1.getTitle(), advertisementDto1.getTitle());
        assertEquals(advertisement1.getSubtitle(), advertisementDto1.getSubtitle());
        assertEquals(advertisement1.getImage(), advertisementDto1.getImage());
        assertEquals(advertisement1.getLocation().getName(), advertisementDto1.getLocation());
        assertEquals(advertisement1.getUrl(), advertisementDto1.getUrl());
    }

    @DisplayName("광고 배포 상태 수정")
    @Test
    void updateAdvertisementIsPublishedTest() {
        // Given
        Long id = 1L;
        when(advertisementRepository.findById(id))
                .thenReturn(java.util.Optional.of(advertisement1));

        // When
        advertisementService.updateAdvertisementIsPublished(id, advertisementDto2);

        // Then
        assertEquals(advertisement1.isPublished(), advertisementDto2.isPublished());
    }
}
