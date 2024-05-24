package com.ssm.backend.domain.exams.services;

import com.ssm.backend.domain.exams.dto.ExamDtl;
import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;

import java.util.List;

public interface ExamService {
    List<ExamMst> getExamList(ExamMst examMst);
    List<ExamMst> getExamList(ExamFilter examFilter);
    List<ExamMst> getExamList(ExamMst examMst, ExamFilter examFilter);
    ExamMst createExam(ExamMst examMst);
    ExamMst getExamMst(ExamMst examMst);
    ExamDtl getExamDtl(ExamDtl examDtl);
    List<ExamDtl> getExamDtlList(ExamDtl examDtl);
    ExamMst updateExamMst(ExamMst examMst);
    ExamDtl updateExamDtl(ExamDtl examDtl);
    ExamDtl createExamDtl(ExamDtl examDtl);
}
