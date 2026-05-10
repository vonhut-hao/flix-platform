package com.flix.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private HttpStatus status;
    private String message;
    private T data;
    @Builder.Default
    private Instant timestamp = Instant.now();

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .status(HttpStatus.OK)
                .message("Success")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, HttpStatus status, String message) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(HttpStatus status, String message) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .build();
    }
}
