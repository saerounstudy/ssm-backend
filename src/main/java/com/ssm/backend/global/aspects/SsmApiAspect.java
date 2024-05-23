package com.ssm.backend.global.aspects;

import com.ssm.backend.global.common.dto.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SsmApiAspect {
    @Pointcut("@within(com.ssm.backend.global.annotations.SsmApi)")
    public void doExecute() {}

    @AfterReturning(value = "doExecute()", returning = "returnVal")
    public void setApiResponse(final JoinPoint joinPoint, BaseResponse returnVal) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        String path = request.getRequestURI();
        returnVal.setPath(path);
        assert response != null;
        response.setStatus(returnVal.getStatus().value());
    }
}
