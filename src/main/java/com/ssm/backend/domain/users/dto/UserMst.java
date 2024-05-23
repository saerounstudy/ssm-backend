package com.ssm.backend.domain.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ssm.backend.global.dto.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class UserMst extends Auditable {
    private long userId;
    private String userEmail;
    private String userName;
    @JsonInclude(Include.NON_NULL)
    private String password;
    @JsonIgnore
    private String passwordHash;
}
