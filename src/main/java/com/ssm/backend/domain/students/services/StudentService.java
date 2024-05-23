package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;

public interface StudentService {
    void createStudentMst(StudentMst studentMst);
    StudentMst getStudentMstWithStudentId(long StudentId);
    StudentMst getStudentMstWithStudentId(StudentMst studentMst);
    void createOneStudent(StudentMst studentMst);
    void updateStudentProfile(StudentProfile studentProfile);
    StudentProfile getStudentProfile(StudentProfile studentProfile);
    StudentProfile getStudentProfile(long studentId);
    void softDeleteStudent(long studentId);
}
