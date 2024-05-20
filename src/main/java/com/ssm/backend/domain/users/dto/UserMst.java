package com.ssm.backend.domain.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.dto.BaseAuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class UserMst extends BaseAuditDTO {
    private long userId;
    private String userEmail;
    private String userName;
    @JsonIgnore
    private String passwordHash;
}
