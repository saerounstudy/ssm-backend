package com.ssm.backend.global.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BaseResponse {
    protected boolean success;
    @JsonIgnore
    protected HttpStatus status;
    protected String path;
    protected LocalDateTime timestamp;
}
