package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.BaseAuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentSurveyScoreHis extends BaseAuditDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private String subjectCd;
    private String subjectName;
    private Integer scoreFirst;
    private Integer scoreSecond;
    private Integer scoreThird;
    private String remark;
}