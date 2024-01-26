package com.healthier.admin.domain.challenge.dto;

import com.healthier.admin.domain.challenge.domain.Stamp;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StampResponse {
    private Long stampId;
    private String userName;
    private String userEmail;
    private String challengeTitle;
    private String stampStatus;
    private String currentDays;
    private LocalDateTime submitTime;

    @Builder
    private StampResponse(
            Long stampId,
            String userName,
            String userEmail,
            String challengeTitle,
            String stampStatus,
            String currentDays,
            LocalDateTime submitTime) {
        this.stampId = stampId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.challengeTitle = challengeTitle;
        this.stampStatus = stampStatus;
        this.currentDays = currentDays;
        this.submitTime = submitTime;
    }

    public static StampResponse from(Stamp stamp) {
        return StampResponse.builder()
                .stampId(stamp.getId())
                .userName(maskUserName(stamp.getUserChallenge().getUser().getProfile().getName()))
                .userEmail(maskUserEmail(stamp.getUserChallenge().getUser().getUsername()))
                .challengeTitle(stamp.getUserChallenge().getChallenge().getTitle())
                .stampStatus(stamp.getStatus().getName())
                .currentDays(String.format("%d일차", stamp.getCurrentDays()))
                .submitTime(stamp.getSubmitTime())
                .build();
    }

    /*
    개인정보 마스킹 - 이름
    이름이 2글자인 경우, 뒤에 한 글자만 마스킹
    이름이 3글자 이상인 경우, 첫번째 글자와 마지막 글자를 제외하고 마스킹
     */
    private static String maskUserName(String userName) {
        if (userName.length() == 2) {
            return userName.charAt(0) + "*";
        } else {
            return userName.charAt(0)
                    + "*".repeat(userName.length() - 2)
                    + userName.charAt(userName.length() - 1);
        }
    }

    /*
    개인정보 마스킹 - 이메일
    @ 앞: 2글자 + ***
    @ 뒤: 그대로
    */
    private static String maskUserEmail(String userEmail) {
        int atIndex = userEmail.indexOf("@");
        return userEmail.substring(0, 2) + "***" + userEmail.substring(atIndex);
    }
}
