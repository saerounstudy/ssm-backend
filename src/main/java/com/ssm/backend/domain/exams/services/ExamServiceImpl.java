package com.ssm.backend.domain.exams.services;

import com.ssm.backend.domain.exams.dto.ExamDtl;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.mappers.ExamMapper;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamMapper examMapper;

    @Override
    public List<ExamMst> getExamList(ExamMst examMst) {
        return examMapper.selectManyExamMst(examMst);
    }
    @Override
    public ExamMst createExam(ExamMst examMst) {
        examMapper.insertExamMst(examMst);
        for (ExamDtl dtl : examMst.getResults()) {
            examMapper.insertExamDtl(dtl);
        }
        return this.getExamMst(examMst);
    }
    @Override
    public ExamMst getExamMst(long examId) {
        return this.getExamMst(ExamMst.builder().examId(examId).build());
    }
    @Override
    public ExamMst getExamMst(ExamMst examMst) {
        return examMapper.selectExamMst(examMst)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND, "존재하지 않는 시험입니다."));
    }

    @Override
    public ExamDtl getExamDtl(ExamDtl examDtl) {
        return examMapper.selectExamDtl(examDtl)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND, "존재하지 않는 시험상세입니다."));
    }
    @Override
    public List<ExamDtl> getExamDtlList(ExamDtl examDtl) {
        return examMapper.selectExamDtlList(examDtl);
    }

    @Override
    public ExamMst updateExamMst(ExamMst examMst) {
        examMapper.updateExamMst(examMst);
        return getExamMst(examMst);
    }

    @Override
    public ExamDtl updateExamDtl(ExamDtl examDtl) {
        examMapper.updateExamDtl(examDtl);
        return getExamDtl(examDtl);
    }
    @Override
    public ExamDtl createExamDtl(ExamDtl examDtl) {
        examMapper.insertExamDtl(examDtl);
        return getExamDtl(examDtl);
    }
}
