package com.healthier.admin.common.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class S3Config {
    @Value("${cloud.aws.s3.access-key}")
    private String AWS_ACCESS_KEY;

    @Value("${cloud.aws.s3.secret-key}")
    private String AWS_SECRET_KEY;

    @Bean
    public S3Presigner s3Presigner() {
        final AwsBasicCredentials awsBasicCredentials =
                AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY);
        final StaticCredentialsProvider staticCredentialsProvider =
                StaticCredentialsProvider.create(awsBasicCredentials);
        return S3Presigner.builder()
                .credentialsProvider(staticCredentialsProvider)
                .region(Region.AP_NORTHEAST_2)
                .build();
    }
}
