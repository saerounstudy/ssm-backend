package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.dto.Auditable;
import com.ssm.backend.global.db.codes.RegistrationSourceCd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentSurveyMst extends Auditable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private RegistrationSourceCd registrationSourceCd;
    private String registrationSourceDetail;
    private String desiredMajorCd;
    private String desiredMajorName;
    private String desiredSchoolCd;
    private String desiredSchoolName;
    private String studentRemark;
    private String counselingNote;
    private List<StudentSurveyScoreHis> scoreHistories;
}
