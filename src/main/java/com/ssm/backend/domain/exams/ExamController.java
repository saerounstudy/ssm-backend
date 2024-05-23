package com.ssm.backend.domain.exams;

import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.services.ExamService;
import com.ssm.backend.global.annotations.SsmApi;
import com.ssm.backend.global.common.dto.ApiResponse;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SsmApi
@RestController
@RequiredArgsConstructor
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    @GetMapping("")
    public ApiResponse<List<ExamMst>> getExamList(ExamMst examMst) {
        List<ExamMst> result = examService.getExamList(examMst);
        return ApiResponse.ok(result);
    }
    @PostMapping("")
    public ApiResponse<ExamMst> createExam(@RequestBody ExamMst examMst) {
        examService.createExam(examMst);
        return ApiResponse.created();
    }

    @GetMapping("/{examId}")
    public ApiResponse<ExamMst> getExamMst(@PathVariable long examId, @RequestParam @Nullable Long studentId) {
        ExamMst examMst = ExamMst.from(examId).includeResult(true);
        if (studentId != null) examMst.setStudentId(studentId);
        ExamMst result = examService.getExamMst(examMst);
        return ApiResponse.ok(result);
    }

    @PatchMapping("/{examId}")
    public ApiResponse<ExamMst> updateExamMst(@PathVariable long examId, @RequestBody ExamMst examMst) {
        examMst.setExamId(examId);
        examService.updateExamMst(examMst);
        return ApiResponse.updated();
    }
}
