package com.ssm.backend.global.aspects;

import com.ssm.backend.global.annotations.Audit;
import com.ssm.backend.global.common.AuditUtil;
import com.ssm.backend.global.common.dto.Auditable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    @Pointcut("@annotation(com.ssm.backend.global.annotations.Audit)")
    private void doExecute() {}

    @Before("doExecute() && @annotation(audit)")
    public void setAuditBeforeMethod(final JoinPoint joinPoint, final Audit audit) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Auditable dto) {
                AuditUtil.setAudit(dto, audit.full());
            }
        }
    }
}
