package com.ssm.backend.domain.users.services;

import com.ssm.backend.domain.users.dto.UserMst;
import com.ssm.backend.domain.users.mappers.UserMapper;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public UserMst selectOneUserWithId(long userId) {
        return userMapper.selectOneUserWithId(userId)
                .orElseThrow(SsmException.supplier(ErrorCode.USER_NOT_FOUND, "userId에 해당하는 유저를 찾을 수 없습니다."));
    }

    @Override
    public UserMst createOneUser(UserMst userMst) {
        userMapper.insertOneUser(userMst);
        return selectOneUserWithId(userMst.getUserId());
    }
}
