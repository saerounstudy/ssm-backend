package com.ssm.backend.domain.exams;

import com.ssm.backend.domain.exams.dto.ExamFilter;
import com.ssm.backend.domain.exams.dto.ExamMst;
import com.ssm.backend.domain.exams.services.ExamService;
import com.ssm.backend.global.annotations.SsmApi;
import com.ssm.backend.global.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SsmApi
@RestController
@RequiredArgsConstructor
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    @GetMapping("")
    public ApiResponse<List<ExamMst>> getExamList(ExamFilter examFilter) {
        List<ExamMst> result = examService.getExamList(examFilter);
        return ApiResponse.ok(result);
    }
    @PostMapping("")
    public ApiResponse<ExamMst> createExam(@RequestBody ExamMst examMst, @RequestHeader(value = "no-return") @Nullable boolean noReturn) {
        examMst.setNoReturn(noReturn);
        ExamMst result = examService.createExam(examMst);
        return ApiResponse.created(result);
    }

    @GetMapping("/{examId}")
    public ApiResponse<ExamMst> getExamMst(@PathVariable long examId) {
        ExamMst examMst = ExamMst.from(examId).includeResult(true);
        ExamMst result = examService.getExamMst(examMst);
        return ApiResponse.ok(result);
    }

    @PatchMapping("/{examId}")
    public ApiResponse<ExamMst> updateExamMst(@PathVariable long examId, @RequestBody ExamMst examMst) {
        examMst.setExamId(examId);
        ExamMst result = examService.updateExamMst(examMst);
        return ApiResponse.updated(result);
    }
}
