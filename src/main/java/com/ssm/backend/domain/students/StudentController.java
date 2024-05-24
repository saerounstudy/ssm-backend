package com.ssm.backend.domain.students;

import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;
import com.ssm.backend.domain.students.services.StudentService;
import com.ssm.backend.global.annotations.SsmApi;
import com.ssm.backend.global.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SsmApi
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ApiResponse<StudentMst> getOneStudentWithId(@PathVariable Long studentId) {
        StudentMst studentMst = StudentMst.builder().studentId(studentId).includeProfile(true).includeSurvey(true).build();
        StudentMst result = studentService.getStudentMst(studentMst);
        return ApiResponse.ok(result);
    }

    @PostMapping("")
    public ApiResponse<StudentMst> createOneStudent(@RequestBody StudentMst studentMst) {
        StudentMst result = studentService.createOneStudent(studentMst);
        return ApiResponse.created(result);
    }
    @GetMapping("/{studentId}/profile")
    public ApiResponse<StudentProfile> getStudentProfile(@PathVariable Long studentId) {
        StudentProfile result = studentService.getStudentProfile(studentId);
        return ApiResponse.ok(result);
    }
    @PatchMapping("/{studentId}/profile")
    public ApiResponse<StudentProfile> updateStudentProfile(@PathVariable Long studentId, @RequestBody StudentProfile studentProfile){
        studentProfile.setStudentId(studentId);
        StudentProfile result = studentService.updateStudentProfile(studentProfile);
        return ApiResponse.updated(result);
    }

    @DeleteMapping("/{studentId}")
    public ApiResponse<StudentMst> softDeleteStudent(@PathVariable Long studentId) {
        StudentMst result = studentService.softDeleteStudent(studentId);
        return ApiResponse.deleted(result);
    }

    @GetMapping("/{studentId}/exams")
    public ApiResponse<List<ExamMst>> getStudentExamList(@PathVariable Long studentId, ExamFilter filter) {
        List<ExamMst> result = studentService.getExamList(studentId, filter);
        return ApiResponse.ok(result);
    }
}
