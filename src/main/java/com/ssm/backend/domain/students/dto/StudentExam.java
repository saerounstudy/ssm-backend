package com.ssm.backend.domain.students.dto;

import com.ssm.backend.global.common.dto.Auditable;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentExam extends Auditable {
    private Long studentId;
    private Long examId;

    public static StudentExam from(Long studentId, Long examId) {
        return new StudentExam(studentId, examId);
    }
}
