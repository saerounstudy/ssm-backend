package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentParentContact;
import com.ssm.backend.domain.students.dto.StudentSurveyMst;
import com.ssm.backend.domain.students.dto.StudentSurveyScoreHis;
import com.ssm.backend.domain.students.mappers.StudentMapper;
import com.ssm.backend.global.common.AuditUtil;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import lombok.RequiredArgsConstructor;
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
    public StudentMst getStudentMstWithStudentId(StudentMst studentMst){
        return studentMapper.selectStudentMstWithStudentId(studentMst)
                .orElseThrow(SsmException.supplier(ErrorCode.STUDENTS_NOT_FOUND, "해당 studentId의 학생을 찾을 수 없습니다."));
    }
    @Override
    public StudentMst createOneStudent(StudentMst studentMst) {
        StudentSurveyMst studentSurveyMst = studentMst.getSurvey();
        if (studentSurveyMst == null) {
            throw SsmException.from(ErrorCode.BAD_STUDENT_BODY, "Survey는 null 일 수 없습니다.");
        }

        AuditUtil.setAudit(studentMst, true);
        AuditUtil.setAudit(studentSurveyMst, true);

        studentMapper.insertOneStudentMst(studentMst);
        Long studentId = studentMst.getStudentId();
        studentMapper.insertOneStudentProfile(studentMst);

        studentSurveyMst.setStudentId(studentId);
        studentMapper.insertOneStudentSurveyMst(studentSurveyMst);

        for (StudentParentContact contact: studentMst.getParentContacts()) {
            AuditUtil.setAudit(contact, true);
            contact.setStudentId(studentId);
            studentMapper.insertOneParentContact(contact);
        }
        for (StudentSurveyScoreHis scoreHis: studentSurveyMst.getScoreHistories()) {
            AuditUtil.setAudit(scoreHis, true);
            scoreHis.setStudentId(studentId);
            studentMapper.insertOneStudentSurveyScoreHis(scoreHis);
        }
        studentMst.setShowSurvey(true);
        return getStudentMstWithStudentId(studentMst);
    }
    @Override
    public StudentMst updateStudentProfile(StudentMst studentMst) {
        if (studentMst.getModifiedAt() == null) {
            AuditUtil.setAudit(studentMst);
        }
        studentMst.setShowSurvey(false);
        getStudentMstWithStudentId(studentMst); // 학생존재여부 체크
        studentMapper.cloneStudentProfileIntoHis(studentMst);
        studentMapper.updateStudentProfile(studentMst);
        return getStudentMstWithStudentId(studentMst);
    }
}
