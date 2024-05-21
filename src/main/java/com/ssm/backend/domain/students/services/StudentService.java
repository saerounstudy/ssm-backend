package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.students.dto.StudentMst;

public interface StudentService {
    void createStudentMst(StudentMst studentMst);
    StudentMst getStudentMstWithStudentId(StudentMst studentMst);
    StudentMst updateStudentProfile(StudentMst studentMst);
}
