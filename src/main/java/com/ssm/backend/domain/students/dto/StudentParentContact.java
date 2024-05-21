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
public class StudentParentContact extends BaseAuditDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private String parentRelationshipCd;
    private String parentRelationshipName;
    private String parentMobileContact;
}
