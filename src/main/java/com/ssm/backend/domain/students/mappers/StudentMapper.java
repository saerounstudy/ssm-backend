package com.ssm.backend.domain.students.mappers;

import com.ssm.backend.domain.students.dto.StudentMst;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface StudentMapper {
    void insertStudentMst(StudentMst studentMst);
    Optional<StudentMst> selectStudentMstWithStudentId(StudentMst studentMst);
    void updateStudentProfile(StudentMst studentMst);
    void cloneStudentProfileIntoHis(StudentMst studentMst);
}
