package com.healthier.admin.common.s3;

import com.healthier.admin.common.dto.ImageUrl;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

@Component
@RequiredArgsConstructor
public class S3UrlGenerator {

    @Value("${cloud.aws.s3.bucket}")
    private String BUCKET;

    private final S3Config s3Config;

    public String generateUrl(String prefix, String filename) {
        PutObjectRequest objectRequest =
                PutObjectRequest.builder().bucket(BUCKET).key(prefix + "/" + filename).build();

        PutObjectPresignRequest presignRequest =
                PutObjectPresignRequest.builder()
                        .signatureDuration(Duration.ofMinutes(10))
                        .putObjectRequest(objectRequest)
                        .build();

        PresignedPutObjectRequest presignedRequest =
                s3Config.s3Presigner().presignPutObject(presignRequest);

        return presignedRequest.url().toString();
    }

    public ImageUrl getUrl(String prefix, String filename) {
        final String url = generateUrl(prefix, filename);
        return ImageUrl.to(url);
    }
}
