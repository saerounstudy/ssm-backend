package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.mappers.ExamMapper;
import com.ssm.backend.domain.students.dto.*;
import com.ssm.backend.domain.students.mappers.StudentMapper;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final ExamMapper examMapper;

    @Override
    public void createStudentMst(StudentMst studentMst){}

    @Override
    public StudentMst getStudentMst(Long studentId) {
        return getStudentMst(StudentMst.builder().studentId(studentId).build());
    }
    @Override
    public StudentMst getStudentMst(StudentMst studentMst){
        return studentMapper.selectStudentMstWithStudentId(studentMst)
                .orElseThrow(SsmException.supplier(ErrorCode.STUDENT_NOT_FOUND));
    }
    @Override
    public StudentMst createOneStudent(StudentMst studentMst) {
        StudentSurveyMst studentSurveyMst = studentMst.getSurvey();
        StudentProfile studentProfile = studentMst.getProfile();
        if (studentSurveyMst == null) {
            throw SsmException.from(ErrorCode.SURVEY_IS_REQUIRED);
        }
        if (studentProfile == null) {
            throw SsmException.from(ErrorCode.PROFILE_IS_REQUIRED);
        }
        studentMapper.insertOneStudentMst(studentMst);
        Long studentId = studentMst.getStudentId();

        // Insert Student Profile
        studentProfile.setStudentId(studentId);
        studentMapper.insertOneStudentProfile(studentProfile);

        // Insert Student Survey Mst
        studentSurveyMst.setStudentId(studentId);
        studentMapper.insertOneStudentSurveyMst(studentSurveyMst);

        // Insert Student Survey Score History
        for (StudentSurveyScoreHis scoreHis: studentSurveyMst.getScoreHistories()) {
            scoreHis.setStudentId(studentId);
            studentMapper.insertOneStudentSurveyScoreHis(scoreHis);
        };
        return this.getStudentMst(studentMst);
    }
    @Override
    public StudentProfile getStudentProfile(StudentProfile studentProfile) {
        if (studentProfile.isNoReturn()) return null;
        return studentMapper.selectOneStudentProfile(studentProfile)
                .orElseThrow(SsmException.supplier(ErrorCode.STUDENT_NOT_FOUND));
    }

    @Override
    public StudentProfile getStudentProfile(Long studentId) {
        return getStudentProfile(StudentProfile.from(studentId));
    }

    @Override
    public StudentProfile updateStudentProfile(StudentProfile studentProfile) {
        if (studentProfile.isEmpty()) {
            throw SsmException.from(ErrorCode.NOTHING_TO_UPDATE);
        }
        getStudentMst(studentProfile.getStudentId()); // 학생 마스터 존재여부 체크
        getStudentProfile(studentProfile); // 학생 프로필 존재여부 체크
        studentMapper.cloneStudentProfileIntoHis(studentProfile);
        studentMapper.updateStudentProfile(studentProfile);
        return this.getStudentProfile(studentProfile);
    }

    @Override
    public StudentMst softDeleteStudent(Long studentId) {
        throw new NotImplementedException();
    }

    @Override
    public void insertStudentExam(StudentExam studentExam) {
        studentMapper.insertStudentExam(studentExam);
    }

    @Override
    public List<ExamMst> getExamList(Long studentId, ExamFilter filter) {
        ExamMst examMst = ExamMst.fromStudentId(studentId);
        return examMapper.selectManyExamMst(examMst, filter);
    }
}
