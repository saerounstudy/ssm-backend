package com.ssm.backend.domain.users;

import com.ssm.backend.domain.users.dto.UserMst;
import com.ssm.backend.domain.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserMst> getOneUserWithId(@PathVariable long userId) {
        UserMst userMst = userService.selectOneUserWithId(userId);
        return ResponseEntity.ok(userMst);
    }
    @PostMapping("")
    public ResponseEntity<UserMst> createOneUser(UserMst userMst) {
        UserMst result = userService.createOneUser(userMst);
        return ResponseEntity.ok(result);
    }
}
