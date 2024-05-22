package com.ssm.backend.domain.students;

import com.ssm.backend.domain.students.dto.StudentMst;
import com.ssm.backend.domain.students.dto.StudentProfile;
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
        StudentMst studentMst = StudentMst.builder().studentId(studentId).includeProfile(true).includeSurvey(true).build();
        StudentMst result = studentService.getStudentMstWithStudentId(studentMst);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<StudentMst> createOneStudent(@RequestBody StudentMst studentMst) {
        StudentMst result = studentService.createOneStudent(studentMst);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/{studentId}/profile")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable long studentId) {
        StudentProfile result = studentService.getStudentProfile(studentId);
        return ResponseEntity.ok(result);
    }
    @PatchMapping("/{studentId}/profile")
    public ResponseEntity<StudentProfile> updateStudentProfile(@PathVariable long studentId, @RequestBody StudentProfile studentProfile){
        studentProfile.setStudentId(studentId);
        StudentProfile result = studentService.updateStudentProfile(studentProfile);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentMst> softDeleteStudent(@PathVariable long studentId) {
        StudentMst result = studentService.softDeleteStudent(studentId);
        return ResponseEntity.ok(result);
    }
}
