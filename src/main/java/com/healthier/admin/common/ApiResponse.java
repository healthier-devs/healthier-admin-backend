package com.healthier.admin.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    public static final ApiResponse<Void> DEFAULT_OK =
            new ApiResponse<>(true, "Operation successful", null, null);

    private boolean success;
    private String message;
    private T data;
    private Metadata metadata;

    @Getter
    @Setter
    public static class Metadata {
        private String requestId;
        private String timestamp;

        public Metadata(String requestId, String timestamp) {
            this.requestId = requestId;
            this.timestamp = timestamp;
        }
    }

    public static <T> ApiResponse<T> createSuccessResponse(T data) {
        return new ApiResponse<>(true, "Request processed successfully", data, null);
    }
}
