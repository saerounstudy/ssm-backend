package com.ssm.backend.domain.users.services;

import com.ssm.backend.domain.users.dto.UserMst;

public interface UserService {
    UserMst selectOneUserWithId(long userId);
    UserMst createOneUser(UserMst userMst);
}
