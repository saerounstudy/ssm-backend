package com.ssm.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private final int status;
    private final String error;
    private final String remark;
    private final String path;
    private final String errorCode;
    private final LocalDateTime timestamp;

    public ErrorResponse(SsmException e) {
        this.status = e.getErrorCode().status();
        this.error = e.getErrorCode().error();
        this.remark = e.getRemark();
        this.path = e.getPath();
        this.errorCode = e.getErrorCode().getCode();
        this.timestamp = LocalDateTime.now();
    }
    public static ResponseEntity<ErrorResponse> toResponseEntity(SsmException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e),
                e.getErrorCode().getStatus()
        );
    }
}