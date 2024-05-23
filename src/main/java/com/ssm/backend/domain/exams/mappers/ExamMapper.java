package com.ssm.backend.domain.exams.mappers;

import com.ssm.backend.domain.exams.dto.ExamDtl;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.global.annotations.Audit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExamMapper {
    List<ExamMst> selectManyExamMst(ExamMst examMst);
    @Audit(full = true)
    void insertExamMst(ExamMst examMst);
    @Audit(full = true)
    void insertExamDtl(ExamDtl examDtl);
    Optional<ExamMst> selectExamMst(ExamMst examMst);
    Optional<ExamDtl> selectExamDtl(ExamDtl examDtl);
    List<ExamDtl> selectExamDtlList(ExamDtl examDtl);
    void updateExamMst(ExamMst examMst);
    void updateExamDtl(ExamDtl examDtl);
}
