package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.BaseAuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentSurveyMst extends BaseAuditDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private String enrollmentSourceCd;
    private String enrollmentSourceName;
    private String enrollmentSourceDetail;
    private String desiredMajorCd;
    private String desiredMajorName;
    private String desiredSchoolCd;
    private String desiredSchoolName;
    private String studentRemark;
    private String counselingNote;
    private List<StudentSurveyScoreHis> scoreHistories;
}
