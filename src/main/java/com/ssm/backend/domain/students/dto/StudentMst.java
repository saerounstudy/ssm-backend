package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ssm.backend.global.common.BaseAuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentMst extends BaseAuditDTO {
    private Long studentId;
    private String studentName;
    private LocalDate birthdate;
    private String gender;
    private String schoolYearCd;
    private String schoolYearName;
    private String schoolCd;
    private String schoolName;
    private String enrollmentStatusCd;
    private String enrollmentStatusName;
    private String studentMobileContact;
    private String studentHomeContact;
    private String homeAddress;
    @JsonInclude(Include.NON_NULL)
    private StudentSurveyMst survey;
    @JsonInclude(Include.NON_EMPTY)
    private List<StudentParentContact> parentContacts;
    @JsonIgnore
    private boolean showSurvey;  // selectStudentMstWithStudentId 조회 시 survey 필드 포함여부
}
