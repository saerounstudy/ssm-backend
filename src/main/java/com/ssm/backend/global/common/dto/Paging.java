package com.ssm.backend.global.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Paging {
    protected Integer page;
    protected Integer size;
    protected List<String> sort;
    protected boolean desc;
}
