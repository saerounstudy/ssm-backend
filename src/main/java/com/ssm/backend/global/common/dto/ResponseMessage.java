package com.ssm.backend.global.common.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ResponseMessage {
    UPDATED("Resource successfully updated!"),
    DELETED("Resource successfully deleted!"),
    CREATED("Resource successfully created!"),
    ;
    private final String message;
    public String message() {  return message; }
}
