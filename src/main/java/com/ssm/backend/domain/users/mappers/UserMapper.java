package com.ssm.backend.domain.users.mappers;

import com.ssm.backend.domain.users.dto.UserMst;
import com.ssm.backend.global.annotations.Audit;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<UserMst> selectOneUserWithId(long userId);
    Optional<UserMst> selectOneUserWithEmail(String userEmail);

    @Audit(full = true)
    long insertOneUser(UserMst userMst);
}
