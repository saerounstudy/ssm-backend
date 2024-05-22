package com.ssm.backend.domain.students.mappers;

import com.ssm.backend.domain.students.dto.*;
import com.ssm.backend.global.annotations.Audit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    void insertStudentMst(StudentMst studentMst);
    Optional<StudentMst> selectStudentMstWithStudentId(StudentMst studentMst);
    @Audit
    void updateStudentProfile(StudentProfile studentProfile);
    void cloneStudentProfileIntoHis(StudentProfile studentProfile);
    @Audit(full = true)
    void insertOneStudentMst(StudentMst studentMst);
    @Audit(full = true)
    void insertOneStudentProfile(StudentProfile studentProfile);
    @Audit(full = true)
    void insertOneStudentSurveyMst(StudentSurveyMst studentSurveyMst);
    @Audit(full = true)
    void insertOneStudentSurveyScoreHis(StudentSurveyScoreHis scoreHis);
    @Audit(full = true)
    void insertOneStudentRegistration(StudentRegistration studentRegistration);
    Optional<StudentProfile> selectOneStudentProfile(StudentProfile studentProfile);
}
