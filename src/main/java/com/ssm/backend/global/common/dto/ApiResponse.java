package com.ssm.backend.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ApiResponse<T> extends BaseResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    ApiResponse(HttpStatus status, T data) {
        this.success = true;
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.data = data;
    }
    ApiResponse(HttpStatus status, T data, ResponseMessage message) {
        this.success = true;
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.data = data;
        this.message = message.message();
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(HttpStatus.OK, data);
    }
    public static <T> ApiResponse<T> deleted() {
        return new ApiResponse<>(HttpStatus.OK, null, ResponseMessage.DELETED);
    }
    public static <T> ApiResponse<T> updated() {
        return new ApiResponse<>(HttpStatus.OK, null, ResponseMessage.UPDATED);
    }
    public static <T> ApiResponse<T> created() {
        return new ApiResponse<>(HttpStatus.CREATED, null, ResponseMessage.CREATED);
    }
}
