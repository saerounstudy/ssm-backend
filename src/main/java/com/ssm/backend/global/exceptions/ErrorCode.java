package com.ssm.backend.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* COMMON */
    /* 400 */
    BAD_BODY_REQUEST(HttpStatus.BAD_REQUEST, "invalid_body", "잘못된 Body값입니다."), // C4001 <- C (Common) 400 (Status code)  1 (SEQ)
    BAD_QUERY_REQUEST(HttpStatus.BAD_REQUEST, "invalid_query_format.", "잘못된 query입니다"),
    BAD_COMMON_CODE(HttpStatus.BAD_REQUEST, "invalid_common_code", "잘못된 공통코드입니다."),
    NOTHING_TO_UPDATE(HttpStatus.BAD_REQUEST, "nothing_to_update", "업데이트할 값이 없습니다."),
    /* USERS */
    /* 400 */
    EMPTY_PASSWORD(HttpStatus.BAD_REQUEST, "empty_password", "비밀번호는 공백일 수 없습니다."),
    /* 404 */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "user_not_found", "존재하지 않는 사용자입니다."),
    /* 409 */
    EMAIL_ALREADY_TAKEN(HttpStatus.CONFLICT, "email_already_taken", "이미 사용중인 이메일입니다."),

    /* STUDENTS */
    /* 400 */
    SURVEY_IS_REQUIRED(HttpStatus.BAD_REQUEST, "survey_is_required", "survey는 필수값입니다."),
    PROFILE_IS_REQUIRED(HttpStatus.BAD_REQUEST, "profile_is_required", "profile은 필수값입니다"),
    /* 404 */
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "student_not_found", "존재하지 않는 학생입니다."),

    /* EXAMS */
    /* 404 */
    EXAM_NOT_FOUND(HttpStatus.NOT_FOUND, "exam_not_found", "존재하지 않는 시험입니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public String toString() {
        return this.status + " " + message + " " + code;
    }

    public String code() { return this.code; }
    public String message() { return this.message; }
    public int status() { return this.status.value(); }
}