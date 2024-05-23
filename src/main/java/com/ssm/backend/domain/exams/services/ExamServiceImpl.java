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
    public void createExam(ExamMst examMst) {
        examMapper.insertExamMst(examMst);
        for (ExamDtl dtl : examMst.getResults()) {
            dtl.setExamId(examMst.getExamId());
            examMapper.insertExamDtl(dtl);
        }
    }
    @Override
    public ExamMst getExamMst(long examId) {
        return this.getExamMst(ExamMst.from(examId));
    }
    @Override
    public ExamMst getExamMst(ExamMst examMst) {
        return examMapper.selectExamMst(examMst)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND));
    }

    @Override
    public ExamDtl getExamDtl(ExamDtl examDtl) {
        return examMapper.selectExamDtl(examDtl)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND));
    }
    @Override
    public List<ExamDtl> getExamDtlList(ExamDtl examDtl) {
        return examMapper.selectExamDtlList(examDtl);
    }

    @Override
    public void updateExamMst(ExamMst examMst) {
        examMapper.updateExamMst(examMst);
    }

    @Override
    public void updateExamDtl(ExamDtl examDtl) {
        examMapper.updateExamDtl(examDtl);
    }
    @Override
    public void createExamDtl(ExamDtl examDtl) {
        examMapper.insertExamDtl(examDtl);
    }
}
