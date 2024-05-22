package com.ssm.backend.global.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    public ResponseEntity<ErrorResponse> handleSsmException(SsmException exception, final HttpServletRequest request) {
        exception.setPath(request.getRequestURI());
        ResponseEntity<ErrorResponse> errorResponse = ErrorResponse.toResponseEntity(exception);
        log.error("[SSM EXCEPTION HANDLING] {}", errorResponse.getBody());
        return errorResponse;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonParseError(final HttpMessageNotReadableException e, final HttpServletRequest request) {
        SsmException exception = SsmException.from(ErrorCode.BAD_BODY_REQUEST, e.getMessage());
        exception.setPath(request.getRequestURI());
        return ErrorResponse.toResponseEntity(exception);
    }
}