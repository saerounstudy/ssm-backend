package com.ssm.backend.domain.exams.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssm.backend.global.common.dto.Auditable;
import com.ssm.backend.global.db.codes.SubjectCd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class ExamDtl extends Auditable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long examId;
    private Long studentId;
    private SubjectCd subjectCd;
    private String subjectName;
    private Double rawScore;
    private Double standardScore;
    private Integer classRank;
    private Integer schoolRank;
    private Double nationalPercentile;
    private Integer grade;

    public boolean hasBody() {
        return this.rawScore != null ||
                this.standardScore != null ||
                this.classRank != null ||
                this.schoolRank != null ||
                this.nationalPercentile != null ||
                this.grade != null;
    }
}
