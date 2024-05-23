package com.ssm.backend.global.db.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum SubjectCd {
    KOREAN("01", "국어"),
    ENGLISH("02", "영어"),
    MATH("03", "수학"),
    SCIENCE("04", "과학"),
    SOCIETY("05", "사회"),
    ;
    private final String code;
    private final String codeName;
    @JsonValue
    public String code() { return this.code; }
    public String codeName() { return this.codeName; }
    public boolean equals(String code) {
        return this.code.equals(code);
    }
    public boolean equals(SubjectCd cd) {
        return this.code.equals(cd.code()) && this.codeName.equals(cd.codeName());
    }

    private static final Map<String, SubjectCd> map = Arrays.stream(SubjectCd.values()).collect(Collectors.toMap(cmCode -> cmCode.code, cmCode -> cmCode));
    @JsonCreator
    public static SubjectCd valueOfCode(String val) {
        if (val == null) return null;
        if (!map.containsKey(val)) throw SsmException.from(ErrorCode.BAD_COMMON_CODE, "유효하지 않은 공통코드 SUBJECT_CD: " + val);
        return map.get(val);
    }
}
