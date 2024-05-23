package com.ssm.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class SsmError {
    private String code;
    private String message;

    public static SsmError with(String code, String message) {
        return new SsmError(code, message);
    }
}
