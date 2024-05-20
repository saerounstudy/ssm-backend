package com.ssm.backend.domain.students;

import com.ssm.backend.domain.students.dto.StudentMst;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/{studentId}")
    public StudentMst getOneStudentWithId(@PathVariable long studentId) {
        return null;
    }
}
