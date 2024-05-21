package com.ssm.backend.domain.students;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public StudentMst getOneStudentWithId(@PathVariable long studentId) {
        StudentMst studentMst = StudentMst.builder()
                .studentId(studentId)
                .showSurvey(true)
                .build();
        return studentService.getStudentMstWithStudentId(studentMst);
    }

    @PatchMapping("/{studentId}/profile")
    public StudentMst updateStudentProfile(@PathVariable long studentId, @RequestBody StudentMst studentMst){
        studentMst.setStudentId(studentId);
        return studentService.updateStudentProfile(studentMst);
    }
}
