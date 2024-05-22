package com.ssm.backend.domain.users.services;

import com.ssm.backend.domain.users.dto.UserMst;
import com.ssm.backend.domain.users.mappers.UserMapper;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import com.ssm.backend.global.security.PasswordHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordHandler passwordHandler;

    @Override
    public UserMst selectOneUserWithId(long userId) {
        return userMapper.selectOneUserWithId(userId)
                .orElseThrow(SsmException.supplier(ErrorCode.USER_NOT_FOUND, "존재하지 않는 유저입니다."));
    }

    @Override
    public UserMst createOneUser(UserMst userMst) {
        if (userMst.getPassword().trim().isEmpty()) {
            throw SsmException.from(ErrorCode.EMPTY_PASSWORD, "비밀번호는 공백일 수 없습니다.");
        }
        if (userMapper.selectOneUserWithEmail(userMst.getUserEmail()).isPresent()) {
            throw SsmException.from(ErrorCode.USER_EMAIL_CONFLICT, "이미 사용중인 Email입니다.");
        }
        String passwordHash = passwordHandler.hash(userMst.getPassword());
        userMst.setPasswordHash(passwordHash);
        
        userMapper.insertOneUser(userMst);
        return selectOneUserWithId(userMst.getUserId());
    }
}
