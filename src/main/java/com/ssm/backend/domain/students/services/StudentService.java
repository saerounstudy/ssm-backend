package com.ssm.backend.domain.students.services;

import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.students.dto.StudentExam;
import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;

import java.util.List;

public interface StudentService {
    void createStudentMst(StudentMst studentMst);
    StudentMst getStudentMst(Long StudentId);
    StudentMst getStudentMst(StudentMst studentMst);
    StudentMst createOneStudent(StudentMst studentMst);
    StudentProfile updateStudentProfile(StudentProfile studentProfile);
    StudentProfile getStudentProfile(StudentProfile studentProfile);
    StudentProfile getStudentProfile(Long studentId);
    StudentMst softDeleteStudent(Long studentId);
    void insertStudentExam(StudentExam studentExam);
    List<ExamMst> getExamList(Long studentId, ExamFilter filter);
}
