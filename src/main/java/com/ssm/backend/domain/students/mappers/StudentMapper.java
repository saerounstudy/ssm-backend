package com.ssm.backend.domain.students.mappers;

import com.ssm.backend.domain.students.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    void insertStudentMst(StudentMst studentMst);
    Optional<StudentMst> selectStudentMstWithStudentId(StudentMst studentMst);
    void updateStudentProfile(StudentMst studentMst);
    void cloneStudentProfileIntoHis(StudentMst studentMst);
    void insertOneStudentMst(StudentMst studentMst);
    void insertOneStudentProfile(StudentMst studentMst);
    void insertOneStudentSurveyMst(StudentSurveyMst studentSurveyMst);
    void insertOneParentContact(StudentParentContact parentContact);
    void insertOneStudentSurveyScoreHis(StudentSurveyScoreHis scoreHis);
    void insertOneStudentRegistration(StudentRegistration studentRegistration);
}
