package com.ssm.backend.domain.students.dto;

import com.ssm.backend.global.dto.BaseAuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentMst extends BaseAuditDTO {
    private long studentId;
    private String studentName;
    private LocalDate birthdate;
    private String currentSchoolYearCd;
    private String enrollmentTypeCd;
}
