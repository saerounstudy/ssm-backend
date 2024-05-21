package com.ssm.backend.global.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class AuditUtil {
    public static void setAudit(BaseAuditDTO dto) {
        setAudit(dto, false);
    }
    public static void setAudit(BaseAuditDTO dto, boolean fullUpdate) {
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
