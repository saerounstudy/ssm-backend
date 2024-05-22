package com.ssm.backend.global.db.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum ExamSessionCd {
    MID("MID", "중간고사"),
    FIN("FIN", "기말고사"),
    JAN("01", "1월"),
    FEB("02", "2월"),
    MAR("03", "3월"),
    APR("04", "4월"),
    MAY("05", "5월"),
    JUN("06", "6월"),
    JUL("07", "7월"),
    AUG("08", "8월"),
    SEP("09", "9월"),
    OCT("10", "10월"),
    NOV("11", "11월"),
    DEC("12", "12월")
    ;
    private final String code;
    private final String codeName;

    @JsonValue
    public String code() { return this.code; }
    public String codeName() { return this.codeName; }

    public boolean equals(String code) {
        return this.code.equals(code);
    }
    public boolean equals(ExamSessionCd cd) {
        return this.code.equals(cd.code()) && this.codeName.equals(cd.codeName());
    }
    private static final Map<String, ExamSessionCd> map = Arrays.stream(ExamSessionCd.values()).collect(Collectors.toMap(cmCode -> cmCode.code, cmCode -> cmCode));
    @JsonCreator
    public static ExamSessionCd valueOfCode(String val) {
        return map.getOrDefault(val, null);
    }
}
