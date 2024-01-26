package com.healthier.admin.challenge.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.healthier.admin.domain.challenge.domain.*;
import com.healthier.admin.domain.challenge.dto.StampResponse;
import com.healthier.admin.domain.challenge.repository.StampRepository;
import com.healthier.admin.domain.challenge.service.StampService;
import com.healthier.admin.domain.user.domain.Profile;
import com.healthier.admin.domain.user.domain.User;
import com.healthier.admin.domain.user.domain.UserStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StampServiceTest {
    @Mock private StampRepository stampRepository;

    @InjectMocks private StampService stampService;

    private UserChallenge userChallenge;
    private Stamp stamp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Challenge challenge = Challenge.builder().id(1L).title("Mock Challenge").build();

        User user =
                User.builder()
                        .id(1L)
                        .username("test@gmail.com")
                        .password("mockpassword")
                        .status(UserStatus.DEFAULT)
                        .profile(Profile.builder().id(1L).name("테스트").build())
                        .build();

        userChallenge =
                UserChallenge.builder()
                        .id(1L)
                        .challenge(challenge)
                        .user(user)
                        .stamps(new ArrayList<>())
                        .joinDate(LocalDate.now())
                        .endDate(LocalDate.now().plusDays(30))
                        .giveUpDate(null)
                        .successPercentage(0.0f)
                        .userChallengeStatus(UserChallengeStatus.PROGRESS)
                        .build();

        stamp =
                Stamp.builder()
                        .id(1L)
                        .status(StampStatus.SUCCESS)
                        .currentDays(1)
                        .image("image1")
                        .userChallenge(userChallenge)
                        .submitTime(LocalDateTime.now())
                        .build();
    }

    @Test
    void getStamp() {
        // Mocking;
        when(stampRepository.findById(1L)).thenReturn(Optional.of(stamp));

        // Test
        StampResponse result = stampService.getStamp(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(stamp.getId(), result.getStampId());
        assertEquals("테*트", result.getUserName());
        assertEquals("te***@gmail.com", result.getUserEmail());
        assertEquals(stamp.getSubmitTime(), result.getSubmitTime());
    }

    @Test
    void updateStampStatus() {
        // Mocking
        StampStatus newStatus = StampStatus.SUCCESS;
        when(stampRepository.findById(1L)).thenReturn(Optional.of(stamp));

        // Test
        assertDoesNotThrow(() -> stampService.updateStampStatus(1L, newStatus));

        // Assertions
        assertEquals(newStatus, stamp.getStatus());
    }
}
