package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class StudentProfile extends Auditable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private String schoolYearCd;
    private String schoolYearName;
    private String schoolCd;
    private String schoolName;
    private String studentStatusCd;
    private String studentStatusName;
    private String studentMobileContact;
    private String studentHomeContact;
    private String homeAddress;
    private String parentContact1;
    private String parentRelationshipCd1;
    private String parentRelationshipName1;
    private String parentContact2;
    private String parentRelationshipCd2;
    private String parentRelationshipName2;
}
