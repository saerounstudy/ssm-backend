package com.ssm.backend.domain.students;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;
import com.ssm.backend.domain.students.services.StudentService;
import com.ssm.backend.global.annotations.SsmApi;
import com.ssm.backend.global.common.dto.ApiResponse;
import com.ssm.backend.global.common.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@SsmApi
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ApiResponse<StudentMst> getOneStudentWithId(@PathVariable long studentId) {
        StudentMst studentMst = StudentMst.builder().studentId(studentId).includeProfile(true).includeSurvey(true).build();
        StudentMst result = studentService.getStudentMstWithStudentId(studentMst);
        return ApiResponse.ok(result);
    }

    @PostMapping("")
    public ApiResponse<StudentMst> createOneStudent(@RequestBody StudentMst studentMst) {
        studentService.createOneStudent(studentMst);
        return ApiResponse.created();
    }
    @GetMapping("/{studentId}/profile")
    public ApiResponse<StudentProfile> getStudentProfile(@PathVariable long studentId) {
        StudentProfile result = studentService.getStudentProfile(studentId);
        return ApiResponse.ok(result);
    }
    @PatchMapping("/{studentId}/profile")
    public ApiResponse<StudentProfile> updateStudentProfile(@PathVariable long studentId, @RequestBody StudentProfile studentProfile){
        studentProfile.setStudentId(studentId);
        studentService.updateStudentProfile(studentProfile);
        return ApiResponse.updated();
    }

    @DeleteMapping("/{studentId}")
    public ApiResponse<StudentMst> softDeleteStudent(@PathVariable long studentId) {
        studentService.softDeleteStudent(studentId);
        return ApiResponse.deleted();
    }
}
