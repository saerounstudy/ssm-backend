package com.ssm.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* COMMON */
    /* 400 */
    BAD_BODY_REQUEST(HttpStatus.BAD_REQUEST, "Wrong Body Format.", "C4001"), // C4001 <- C (Common) 400 (Status code)  1 (SEQ)
    BAD_QUERY_REQUEST(HttpStatus.BAD_REQUEST, "Wrong Query Format.", "C4002"),

    /* USERS */
    /* 400 */
    EMPTY_PASSWORD(HttpStatus.BAD_REQUEST, "Password cannot be empty", "U4001"),
    /* 404 */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found", "U4041"),
    /* 409 */
    USER_EMAIL_CONFLICT(HttpStatus.CONFLICT, "User email already exists", "U4091"),

    /* STUDENTS */
    /* 400 */
    BAD_STUDENT_BODY(HttpStatus.BAD_REQUEST, "Wrong Body Format", "S4001"),
    /* 404 */
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Student not found", "S4041"),
    ;
    private final HttpStatus status;
    private final String message;
    private final String code;

    @Override
    public String toString() {
        return this.status + " " + message + " " + code;
    }

    public String error() { return this.status.name() + ": " + this.getMessage(); }
    public int status() { return this.status.value(); }
}