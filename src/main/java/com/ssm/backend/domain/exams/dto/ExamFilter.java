package com.ssm.backend.domain.exams.dto;

import com.ssm.backend.global.common.dto.Paging;
import com.ssm.backend.global.db.codes.ExamSessionCd;
import com.ssm.backend.global.db.codes.ExamTypeCd;
import com.ssm.backend.global.db.codes.SchoolYearCd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ExamFilter extends Paging {
    private Integer examYear;
    private Integer examMonth;
    private SchoolYearCd studentSchoolYearCd;
    private ExamTypeCd examTypeCd;
    private ExamSessionCd examSessionCd;

    public static ExamFilter of() {
        return new ExamFilter();
    }
}
