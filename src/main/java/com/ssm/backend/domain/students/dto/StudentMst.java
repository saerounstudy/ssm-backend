package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ssm.backend.global.common.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentMst extends Auditable {
    private Long studentId;
    private String studentName;
    private LocalDate birthdate;
    private String gender;
    private StudentProfile profile;
    @JsonInclude(Include.NON_NULL)
    private StudentSurveyMst survey;
    @JsonIgnore
    private boolean includeProfile;  // selectStudentMstWithStudentId 조회 시 profile 필드 포함여부
    @JsonIgnore
    private boolean includeSurvey;  // selectStudentMstWithStudentId 조회 시 survey 필드 포함여부
}
