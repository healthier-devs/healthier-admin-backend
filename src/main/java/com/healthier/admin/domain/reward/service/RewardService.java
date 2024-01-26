package com.healthier.admin.domain.reward.service;

import static com.healthier.admin.common.utils.PropertyUpdater.updateProperty;

import com.healthier.admin.common.dto.PageCondition;
import com.healthier.admin.common.dto.PageResponse;
import com.healthier.admin.domain.reward.domain.Reward;
import com.healthier.admin.domain.reward.domain.UserReward;
import com.healthier.admin.domain.reward.dto.RewardDto;
import com.healthier.admin.domain.reward.dto.UserRewardResponse;
import com.healthier.admin.domain.reward.repository.RewardRepository;
import com.healthier.admin.domain.reward.repository.UserRewardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RewardService {

    private final RewardRepository rewardRepository;
    private final UserRewardRepository userRewardRepository;

    // 리워드 목록 조회
    public PageResponse<List<RewardDto>> getAllRewards(PageCondition pageCondition) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<Reward> rewards = rewardRepository.findAll(pageable);
        List<RewardDto> rewardResponses = rewards.map(RewardDto::fromPreview).toList();
        return new PageResponse<>(rewardResponses, rewards.getTotalElements());
    }

    // 리워드 개별 조회
    public RewardDto getReward(Long id) {
        return rewardRepository
                .findById(id)
                .map(RewardDto::fromDetail)
                .orElseThrow(() -> new IllegalArgumentException("해당 리워드가 존재하지 않습니다."));
    }

    // 리워드 생성
    @Transactional
    public void createReward(RewardDto rewardDto) {
        Reward reward = Reward.from(rewardDto);
        rewardRepository.save(reward);
    }

    // 리워드 수정
    @Transactional
    public void updateReward(Long id, RewardDto rewardDto) {
        Reward reward =
                rewardRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 리워드가 존재하지 않습니다."));
        updateProperty(rewardDto.getType(), reward::updateType);
        updateProperty(rewardDto.getPoint(), reward::updatePoint);
        updateProperty(rewardDto.getActualPrice(), reward::updateActualPrice);
        updateProperty(rewardDto.getName(), reward::updateName);
        updateProperty(rewardDto.getDuration(), reward::updateDuration);
        updateProperty(rewardDto.getProductNotice(), reward::updateProductNotice);
        updateProperty(rewardDto.getRewardNotice(), reward::updateRewardNotice);
        updateProperty(rewardDto.getImageUrl(), reward::updateImageUrl);
        updateProperty(rewardDto.isPublic(), reward::updateIsPublic);

        rewardRepository.save(reward);
    }

    // 리워드 지급 전체 조회
    public PageResponse<List<UserRewardResponse>> getAllUserRewards(PageCondition pageCondition) {
        Pageable pageable = PageRequest.of(pageCondition.getPage(), pageCondition.getSize());
        Page<UserReward> userRewards = userRewardRepository.findIsSelected(pageable);
        List<UserRewardResponse> userRewardResponses =
                userRewards.map(UserRewardResponse::from).toList();
        return new PageResponse<>(userRewardResponses, userRewards.getTotalElements());
    }

    // 리워드 지급 상태 변경
    @Transactional
    public void updateSendStatus(Long userRewardId) {
        UserReward reward =
                userRewardRepository
                        .findById(userRewardId)
                        .orElseThrow(() -> new IllegalArgumentException("해당 리워드가 존재하지 않습니다."));
        if (!reward.isSelected()) {
            throw new IllegalStateException("해당 리워드가 선택되지 않았습니다.");
        }
        reward.updateIsSent();
        // TODO: 푸쉬 알림 전송
        userRewardRepository.save(reward);
    }
}
