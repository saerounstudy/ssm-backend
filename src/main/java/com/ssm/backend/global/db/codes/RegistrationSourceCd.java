package com.ssm.backend.global.db.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum RegistrationSourceCd {
    FRIEND( "01", "친구"),
    PARENT( "02", "부모님 권유"),
    FLIER( "03", "전단지"),
    CUSTOM( "90", "사용자 입력") ;
    private final String code;
    private final String codeName;
    @JsonValue
    public String code() { return this.code; }
    public String codeName() { return this.codeName; }
    public boolean equals(String code) {
        return this.code.equals(code);
    }
    public boolean equals(RegistrationSourceCd cd) {
        return this.code.equals(cd.code()) && this.codeName.equals(cd.codeName());
    }
    private static final Map<String, RegistrationSourceCd> map = Arrays.stream(RegistrationSourceCd.values()).collect(Collectors.toMap(cmCode -> cmCode.code, cmCode -> cmCode));
    @JsonCreator
    public static RegistrationSourceCd valueOfCode(String val) {
        return map.getOrDefault(val, null);
    }
}
