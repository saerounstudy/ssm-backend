package com.ssm.backend.global.exceptions;

import lombok.*;

import java.util.function.Supplier;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class SsmException extends RuntimeException {
    private ErrorCode errorCode;
    private String remark;
    private String path;

    SsmException(ErrorCode errorCode, String remark) {
        this.errorCode = errorCode;
        this.remark = remark;
        this.path = null;
    }

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