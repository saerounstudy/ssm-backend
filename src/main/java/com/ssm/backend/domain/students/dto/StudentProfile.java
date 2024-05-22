package com.ssm.backend.domain.students.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.Auditable;
import com.ssm.backend.global.db.codes.ParentRelationshipCd;
import com.ssm.backend.global.db.codes.SchoolYearCd;
import com.ssm.backend.global.db.codes.StudentStatusCd;
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
    private SchoolYearCd schoolYearCd;
    private String schoolYearName;
    private String schoolCd;
    private String schoolName;
    private StudentStatusCd studentStatusCd;
    private String studentStatusName;
    private String studentMobileContact;
    private String studentHomeContact;
    private String homeAddress;
    private String parentContact1;
    private ParentRelationshipCd parentRelationshipCd1;
    private String parentRelationshipName1;
    private String parentContact2;
    private ParentRelationshipCd parentRelationshipCd2;
    private String parentRelationshipName2;
}
