package com.ssm.backend.domain.exams.services;

import com.ssm.backend.domain.exams.dto.ExamDtl;
import com.ssm.backend.domain.exams.dto.ExamMst;

import java.util.List;

public interface ExamService {
    List<ExamMst> getExamList(ExamMst examMst);
    void createExam(ExamMst examMst);
    ExamMst getExamMst(long examId);
    ExamMst getExamMst(ExamMst examMst);
    ExamDtl getExamDtl(ExamDtl examDtl);
    List<ExamDtl> getExamDtlList(ExamDtl examDtl);
    void updateExamMst(ExamMst examMst);
    void updateExamDtl(ExamDtl examDtl);
    void createExamDtl(ExamDtl examDtl);
}
