package com.ssm.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
@ToString
public class SsmException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String remark;

    public static SsmException from(ErrorCode errorCode, String remark) {
        return new SsmException(errorCode, remark);
    }
    public static SsmException from(ErrorCode errorCode) {
        return new SsmException(errorCode, null);
    }
    public static Supplier<SsmException> supplier(ErrorCode errorCode) {
        return () -> SsmException.from(errorCode);
    }
    public static Supplier<SsmException> supplier(ErrorCode errorCode, String remark) {
        return () -> SsmException.from(errorCode, remark);
    }
}