package com.ssm.backend.domain.students;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentMst> getOneStudentWithId(@PathVariable long studentId) {
        StudentMst studentMst = StudentMst.builder()
                .studentId(studentId)
                .showSurvey(true)
                .build();
        StudentMst result = studentService.getStudentMstWithStudentId(studentMst);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<StudentMst> createOneStudent(@RequestBody StudentMst studentMst) {
        StudentMst result = studentService.createOneStudent(studentMst);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PatchMapping("/{studentId}/profile")
    public ResponseEntity<StudentMst> updateStudentProfile(@PathVariable long studentId, @RequestBody StudentMst studentMst){
        studentMst.setStudentId(studentId);
        StudentMst result = studentService.updateStudentProfile(studentMst);
        return ResponseEntity.ok(result);
    }
}
