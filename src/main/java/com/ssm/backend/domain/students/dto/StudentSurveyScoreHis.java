package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.Auditable;
import com.ssm.backend.global.db.codes.SubjectCd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentSurveyScoreHis extends Auditable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private SubjectCd subjectCd;
    private String subjectName;
    private Integer scoreFirst;
    private Integer scoreSecond;
    private Integer scoreThird;
    private String remark;
}
