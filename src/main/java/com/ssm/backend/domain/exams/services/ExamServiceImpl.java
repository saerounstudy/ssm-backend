package com.ssm.backend.domain.exams.services;

import com.ssm.backend.domain.exams.dto.ExamDtl;
import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.mappers.ExamMapper;
import com.ssm.backend.domain.students.dto.StudentExam;
import com.ssm.backend.domain.students.services.StudentService;
import com.ssm.backend.global.db.codes.ExamSessionCd;
import com.ssm.backend.global.db.codes.ExamTypeCd;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamMapper examMapper;
    private final StudentService studentService;

    @Override
    public List<ExamMst> getExamList(ExamMst examMst) {
        return getExamList(examMst, ExamFilter.of());
    }
    @Override
    public List<ExamMst> getExamList(ExamFilter examFilter) {
        return getExamList(ExamMst.from(), examFilter);
    }
    @Override
    public List<ExamMst> getExamList(ExamMst examMst, ExamFilter examFilter) {
        return examMapper.selectManyExamMst(examMst, examFilter);
    }

    @Override
    public ExamMst createExam(ExamMst examMst) {
        ExamTypeCd examType = examMst.getExamTypeCd();
        ExamSessionCd examSession = examMst.getExamSessionCd();
        if (examType == ExamTypeCd.RE && (examSession != ExamSessionCd.MID && examSession != ExamSessionCd.FIN)) {
            throw SsmException.from(ErrorCode.INVALID_EXAM_SESSION_REAL);
        }
        if (examType == ExamTypeCd.MO && (examSession == ExamSessionCd.MID || examSession == ExamSessionCd.FIN)) {
            throw SsmException.from(ErrorCode.INVALID_EXAM_SESSION_MOCK);
        }
        examMapper.insertExamMst(examMst);
        Long examId = examMst.getExamId();
        Set<StudentExam> studentExamSet = new HashSet<>();
        for (ExamDtl dtl : examMst.getResults()) {
            dtl.setExamId(examId);
            examMapper.insertExamDtl(dtl);
            studentExamSet.add(StudentExam.from(dtl.getStudentId(), examId));
        }
        for (StudentExam studentExam : studentExamSet) {
            studentService.insertStudentExam(studentExam);
        }
        return this.getExamMst(examMst);
    }

    @Override
    public ExamMst getExamMst(ExamMst examMst) {
        if (examMst.isNoReturn()) return null;
        return examMapper.selectExamMst(examMst)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND));
    }

    @Override
    public ExamDtl getExamDtl(ExamDtl examDtl) {
        if (examDtl.isNoReturn()) return null;
        return examMapper.selectExamDtl(examDtl)
                .orElseThrow(SsmException.supplier(ErrorCode.EXAM_NOT_FOUND));
    }

    @Override
    public List<ExamDtl> getExamDtlList(ExamDtl examDtl) {
        return examMapper.selectManyExamDtl(examDtl);
    }

    @Override
    public ExamMst updateExamMst(ExamMst examMst) {
        examMapper.updateExamMst(examMst);
        return this.getExamMst(examMst);
    }

    @Override
    public ExamDtl updateExamDtl(ExamDtl examDtl) {
        examMapper.updateExamDtl(examDtl);
        return this.getExamDtl(examDtl);
    }
    @Override
    public ExamDtl createExamDtl(ExamDtl examDtl) {
        examMapper.insertExamDtl(examDtl);
        return this.getExamDtl(examDtl);
    }
}
