package com.healthier.admin.challenge.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.healthier.admin.domain.challenge.domain.Challenge;
import com.healthier.admin.domain.challenge.domain.ChallengeCategory;
import com.healthier.admin.domain.challenge.repository.ChallengeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChallengeRepositoryTest {

    @Autowired private ChallengeRepository challengeRepository;

    @Test
    public void saveChallengeTest() {
        // Given
        Challenge challenge =
                Challenge.builder()
                        .title("챌린지 테스트")
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

        // When
        Challenge savedChallenge = challengeRepository.save(challenge);

        // Then
        assertThat(savedChallenge.getId()).isNotNull();
        assertThat(savedChallenge.getTitle()).isEqualTo("챌린지 테스트");
    }
}
