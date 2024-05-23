package com.ssm.backend.global.exceptions;

import com.ssm.backend.global.common.dto.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@AllArgsConstructor
@ToString
public class ErrorResponse extends BaseResponse {
    private SsmError error;

    public ErrorResponse(SsmException e) {
        String message = e.getRemark() == null ? e.getErrorCode().message() : e.getRemark();
        this.error = SsmError.with(e.getErrorCode().code(), message);
        this.status = e.getErrorCode().getStatus();
        this.success = false;
        this.timestamp = LocalDateTime.now();
        this.path = e.getPath();
    }
    public static ErrorResponse from(SsmException e) {
        return new ErrorResponse(e);
    }
    public static ResponseEntity<ErrorResponse> toResponseEntity(SsmException e) {
        return new ResponseEntity<>(
                ErrorResponse.from(e),
                e.getErrorCode().getStatus()
        );
    }
}