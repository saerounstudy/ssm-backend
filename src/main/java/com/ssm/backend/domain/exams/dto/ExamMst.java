package com.ssm.backend.domain.exams.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssm.backend.global.common.dto.Auditable;
import com.ssm.backend.global.db.codes.ExamSessionCd;
import com.ssm.backend.global.db.codes.ExamTypeCd;
import com.ssm.backend.global.db.codes.SchoolYearCd;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class ExamMst extends Auditable {
    private Long examId;
    private Integer examYear;
    private Integer examMonth;
    private SchoolYearCd studentSchoolYearCd;
    private String studentSchoolYearName;
    private ExamTypeCd examTypeCd;
    private String examTypeName;
    private ExamSessionCd examSessionCd;
    private String examSessionName;
    private String examOrganizer;
    private String schoolCd;
    private String schoolName;
    private List<ExamDtl> results;
    @JsonIgnore
    private Long studentId; //조회조건에 사용
    @JsonIgnore
    private boolean includeResult;

    public static ExamMst from(long examId) {
        return ExamMst.builder().examId(examId).build();
    }
    public ExamMst includeResult(boolean val) {
        this.includeResult = val;
        return this;
    }
    public boolean hasBody() {
        return this.examId != null ||
                this.examYear != null ||
                this.examMonth != null ||
                this.studentSchoolYearCd != null ||
                this.examTypeCd != null ||
                this.examSessionCd != null ||
                this.examOrganizer != null;
    }
}
