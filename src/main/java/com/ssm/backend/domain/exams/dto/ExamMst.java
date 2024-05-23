package com.ssm.backend.domain.exams.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssm.backend.global.dto.Auditable;
import com.ssm.backend.global.db.codes.ExamSessionCd;
import com.ssm.backend.global.db.codes.ExamTypeCd;
import com.ssm.backend.global.db.codes.SchoolYearCd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
    private ExamTypeCd examTypeCd;
    private ExamSessionCd examSessionCd;
    private String examOrganizer;
    private String schoolCd;
    private List<ExamDtl> results;
    @JsonIgnore
    private Long studentId; //조회조건에 사용
    @JsonIgnore
    private boolean includeResult;

}
