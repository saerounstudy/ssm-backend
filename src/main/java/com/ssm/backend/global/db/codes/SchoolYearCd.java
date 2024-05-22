package com.ssm.backend.global.db.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@AllArgsConstructor
public enum SchoolYearCd {
    E1("E1", "초1"),
    E2("E2", "초2"),
    E3("E3", "초3"),
    E4("E4", "초4"),
    E5("E5", "초5"),
    E6("E6", "초6"),
    M1("M1", "중1"),
    M2("M2", "중2"),
    M3("M3", "중3"),
    H1("H1", "고1"),
    H3("H3", "고2"),
    H2("H2", "고3")
    ;
    private final String code;
    private final String codeName;
    @JsonValue
    public String code() { return this.code; }
    public String codeName() { return this.codeName; }

    private static final Map<String, SchoolYearCd> map = Arrays.stream(SchoolYearCd.values()).collect(Collectors.toMap(cmCode -> cmCode.code, cmCode -> cmCode));
    @JsonCreator
    public static SchoolYearCd valueOfCode(String val) {
        return map.getOrDefault(val, null);
    }
}
