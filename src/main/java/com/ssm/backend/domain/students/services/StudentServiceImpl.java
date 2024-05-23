package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;
import com.ssm.backend.domain.students.dto.StudentSurveyMst;
import com.ssm.backend.domain.students.dto.StudentSurveyScoreHis;
import com.ssm.backend.domain.students.mappers.StudentMapper;
import com.ssm.backend.global.common.dto.ResponseMessage;
import com.ssm.backend.global.common.dto.ServiceResult;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    @Override
    public void createStudentMst(StudentMst studentMst){}

    @Override
    public StudentMst getStudentMstWithStudentId(long studentId) {
        return getStudentMstWithStudentId(StudentMst.builder().studentId(studentId).build());
    }
    @Override
    public StudentMst getStudentMstWithStudentId(StudentMst studentMst){
        return studentMapper.selectStudentMstWithStudentId(studentMst)
                .orElseThrow(SsmException.supplier(ErrorCode.STUDENT_NOT_FOUND));
    }
    @Override
    public void createOneStudent(StudentMst studentMst) {
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
    }
    @Override
    public StudentProfile getStudentProfile(StudentProfile studentProfile) {
        return studentMapper.selectOneStudentProfile(studentProfile)
                .orElseThrow(SsmException.supplier(ErrorCode.STUDENT_NOT_FOUND));
    }

    @Override
    public StudentProfile getStudentProfile(long studentId) {
        return getStudentProfile(StudentProfile.builder().studentId(studentId).build());
    }
    @Override
    public void updateStudentProfile(StudentProfile studentProfile) {
        if (studentProfile.isEmpty()) {
            throw SsmException.from(ErrorCode.NOTHING_TO_UPDATE);
        }
        getStudentMstWithStudentId(studentProfile.getStudentId()); // 학생 마스터 존재여부 체크
        StudentProfile p = getStudentProfile(studentProfile); // 학생 프로필 존재여부 체크
        studentMapper.cloneStudentProfileIntoHis(studentProfile);
        studentMapper.updateStudentProfile(studentProfile);
    }

    @Override
    public void softDeleteStudent(long studentId) {
        throw new NotImplementedException();
    }
}
