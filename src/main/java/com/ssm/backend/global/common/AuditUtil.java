package com.ssm.backend.global.common;

import com.ssm.backend.global.common.dto.Auditable;
import com.ssm.backend.global.exceptions.ErrorCode;
import com.ssm.backend.global.exceptions.SsmException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Log4j2
@Component
public class AuditUtil {
    public void setAudit(Auditable dto) {
        setAudit(dto, false);
    }
    public void setAudit(Auditable dto, boolean fullUpdate) {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (attributes == null) {
            throw SsmException.from(ErrorCode.MISSING_REQUEST_ATTRIBUTE, "[SERVER ERROR] Request is null, failed to set Audit");
        }
        HttpServletRequest request = attributes.getRequest();
        if (dto.getModifiedAt() == null) {
            dto.setModifiedAt(LocalDateTime.now());
        }
        if (dto.getModifiedBy() == null) {
            dto.setModifiedBy("TEST-ADMIN");
        }
        if (!fullUpdate) return;
        if (dto.getCreatedAt() == null) {
            dto.setCreatedAt(LocalDateTime.now());
        }
        if (dto.getCreatedBy() == null) {
            dto.setCreatedBy("TEST-ADMIN");
        }
    }
}
