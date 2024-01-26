package com.healthier.admin.reward;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.healthier.admin.domain.reward.domain.Reward;
import com.healthier.admin.domain.reward.domain.UserReward;
import com.healthier.admin.domain.reward.dto.RewardDto;
import com.healthier.admin.domain.reward.repository.RewardRepository;
import com.healthier.admin.domain.reward.repository.UserRewardRepository;
import com.healthier.admin.domain.reward.service.RewardService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RewardServiceTest {
    @Mock private RewardRepository rewardRepository;

    @Mock private UserRewardRepository userRewardRepository;

    @InjectMocks private RewardService rewardService;

    private Long rewardId = 1L;
    private Reward reward;
    private RewardDto rewardDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reward =
                Reward.builder()
                        .id(rewardId)
                        .type("배달의 민족")
                        .point(3000)
                        .actualPrice(2800)
                        .name("3000원 상품권")
                        .build();

        rewardDto =
                RewardDto.builder()
                        .id(rewardId)
                        .type("배달의 민족")
                        .point(3000)
                        .actualPrice(2800)
                        .name("3000원 상품권")
                        .build();
    }

    @Test
    void testGetReward() {
        RewardDto rewardDto = RewardDto.fromDetail(reward);
        when(rewardRepository.findById(rewardId)).thenReturn(Optional.of(reward));

        RewardDto result = rewardService.getReward(rewardId);

        verify(rewardRepository, times(1)).findById(rewardId);
        assertEquals(rewardDto.getName(), result.getName());
        assertEquals(rewardDto.getPoint(), result.getPoint());
        assertEquals(rewardDto.getActualPrice(), result.getActualPrice());
        assertEquals(rewardDto.getType(), result.getType());
    }

    @Test
    void testCreateReward() {
        rewardService.createReward(rewardDto);
        verify(rewardRepository, times(1)).save(any());
    }

    @Test
    void testUpdateReward() {
        RewardDto rewardDto =
                RewardDto.builder()
                        .type("네이버페이")
                        .point(10000)
                        .actualPrice(8000)
                        .name("10000원 상품권")
                        .build();
        when(rewardRepository.findById(rewardId)).thenReturn(Optional.of(reward));

        rewardService.updateReward(rewardId, rewardDto);

        verify(rewardRepository, times(1)).save(any());
        assertEquals(rewardDto.getType(), reward.getType());
        assertEquals(rewardDto.getPoint(), reward.getPoint());
        assertEquals(rewardDto.getActualPrice(), reward.getActualPrice());
        assertEquals(rewardDto.getName(), reward.getName());
    }

    @Test
    void testUpdateSendStatus() {
        Long userRewardId = 1L;
        UserReward userReward =
                UserReward.builder().id(userRewardId).isSelected(true).isSent(false).build();
        when(userRewardRepository.findById(userRewardId)).thenReturn(Optional.of(userReward));

        rewardService.updateSendStatus(userRewardId);
        verify(userRewardRepository, times(1)).save(any());
        assertTrue(userReward.isSent());
    }
}
