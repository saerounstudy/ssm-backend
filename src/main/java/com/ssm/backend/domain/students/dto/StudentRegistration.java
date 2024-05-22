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
public class StudentRegistration extends Auditable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long studentId;
    private Long registrationSeq;
    private String registrationTypeCd;
    private String registrationReasonMainCd;
    private String registrationReasonSubCd;
    private String registrationReasonContent;
}
