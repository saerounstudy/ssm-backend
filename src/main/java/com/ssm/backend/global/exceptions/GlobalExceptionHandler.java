package com.ssm.backend.global.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Business Exception Hanlding
     * 비즈니스 요구사항 예외 처리
     */
    @ExceptionHandler(SsmException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(final SsmException e) {
        ResponseEntity<ErrorResponse> errorResponse = ErrorResponse.toResponseEntity(e);
        log.error("[SSM EXCEPTION HANDLING] {}", errorResponse.getBody());
        return errorResponse;
    }
}