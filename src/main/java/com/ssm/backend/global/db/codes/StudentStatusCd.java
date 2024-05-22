package com.ssm.backend.global.db.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum StudentStatusCd {
    ENROLLED("10", "수강"),
    GRADUATED("90", "졸업"),
    WITHDRAWN("95", "퇴회"),
    DELETED("99", "삭제"),
    ;
    private final String code;
    private final String codeName;
    @JsonValue
    public String code() { return this.code; }
    public String codeName() { return this.codeName; }

    public boolean equals(String code) {
        return this.code.equals(code);
    }
    public boolean equals(StudentStatusCd cd) {
        return this.code.equals(cd.code()) && this.codeName.equals(cd.codeName());
    }
    private static final Map<String, StudentStatusCd> map = Arrays.stream(StudentStatusCd.values()).collect(Collectors.toMap(cmCode -> cmCode.code, cmCode -> cmCode));
    @JsonCreator
    public static StudentStatusCd valueOfCode(String val) {
        return map.getOrDefault(val, null);
    }
}
