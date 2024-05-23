package com.ssm.backend.domain.exams;

import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.services.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    @GetMapping("")
    public ResponseEntity<List<ExamMst>> getExamList(ExamMst examMst) {
        List<ExamMst> result = examService.getExamList(examMst);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public ResponseEntity<ExamMst> createExam(@RequestBody ExamMst examMst) {
        ExamMst result = examService.createExam(examMst);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExamMst> getExamMst(@PathVariable long examId) {
        ExamMst examMst = ExamMst.builder()
                                .examId(examId)
                                .includeResult(true)
                                .build();
        ExamMst result = examService.getExamMst(examMst);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{examId}")
    public ResponseEntity<ExamMst> updateExamMst(@PathVariable long examId, @RequestBody ExamMst examMst) {
        examMst.setExamId(examId);
        ExamMst result = examService.updateExamMst(examMst);
        return ResponseEntity.ok(result);
    }
}
