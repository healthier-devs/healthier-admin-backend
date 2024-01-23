package com.healthier.admin.challenge.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.healthier.admin.domain.challenge.domain.Challenge;
import com.healthier.admin.domain.challenge.domain.ChallengeCategory;
import com.healthier.admin.domain.challenge.dto.ChallengeRequest;
import com.healthier.admin.domain.challenge.dto.ChallengeResponse;
import com.healthier.admin.domain.challenge.repository.ChallengeRepository;
import com.healthier.admin.domain.challenge.service.ChallengeService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ChallengeServiceTest {
    @Mock private ChallengeRepository challengeRepository;
    @InjectMocks private ChallengeService challengeService;

    private Challenge challenge;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // 테스트용 공통 데이터
        challenge =
                Challenge.builder()
                        .title("잠 잘 자기")
                        .category(ChallengeCategory.SLEEP)
                        .count(0)
                        .midtermGift(3000)
                        .finalGift(10000)
                        .duration(28)
                        .times("매일인증")
                        .method("사진인증")
                        .basicImage("이미지 url")
                        .whatContent("무엇을 하는 챌린지인가")
                        .whyContent("왜 해야 하는가")
                        .tipSubtitle("꿀팁")
                        .tipContent("꿀팁 내용")
                        .guide("사진 촬영 가이드")
                        .successImage1("성공사진1")
                        .successImage2("성공사진2")
                        .failImage1("실패사진1")
                        .failImage2("실패사진2")
                        .isPublic(true)
                        .build();
    }

    @Test
    void testCreateChallenge() {
        ChallengeRequest challengeRequest =
                ChallengeRequest.builder()
                        .title("운동 열심히 하기")
                        .category(ChallengeCategory.EXERCISE)
                        .midtermGift(3000)
                        .finalGift(10000)
                        .duration(28)
                        .times("매일인증")
                        .method("사진인증")
                        .whatContent("무엇을 하는 챌린지인가")
                        .whyContent("왜 해야 하는가")
                        .tipSubtitle("꿀팁")
                        .tipContent("꿀팁 내용")
                        .guide("사진 촬영 가이드")
                        .successImage1("성공사진1")
                        .successImage2("성공사진2")
                        .failImage1("실패사진1")
                        .failImage2("실패사진2")
                        .isPublic(true)
                        .image("이미지 URL")
                        .build();

        assertDoesNotThrow(() -> challengeService.createChallenge(challengeRequest));

        verify(challengeRepository, times(1)).save(any(Challenge.class));
    }

    @Test
    void testUpdateChallenge() {
        Long id = 1L;
        ChallengeRequest challengeRequest =
                ChallengeRequest.builder().whatContent("운동을 열심히 해요").whyContent("건강에 좋습니다").build();

        when(challengeRepository.findById(id)).thenReturn(Optional.of(challenge));

        assertDoesNotThrow(() -> challengeService.updateChallenge(id, challengeRequest));

        verify(challengeRepository, times(1)).save(any(Challenge.class));
        assertEquals(challengeRequest.getWhatContent(), challenge.getWhatContent());
        assertEquals(challengeRequest.getWhyContent(), challenge.getWhyContent());
    }

    @Test
    void testGetChallenge() {
        Long id = 1L;

        when(challengeRepository.findById(id)).thenReturn(Optional.of(challenge));

        ChallengeResponse challengeResponse = challengeService.getChallenge(id);

        assertEquals(challenge.getId(), challengeResponse.getId());
        assertEquals(challenge.getTitle(), challengeResponse.getTitle());
    }
}
