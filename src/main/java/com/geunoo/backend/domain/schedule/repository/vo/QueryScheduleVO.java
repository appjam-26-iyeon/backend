package com.geunoo.backend.domain.schedule.repository.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class QueryScheduleVO {
    private final Long scheduleId;
    private final String name;
    private final Boolean isTogether;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate endDate;
    private final String username;

    @QueryProjection
    public QueryScheduleVO(Long scheduleId, String name, Boolean isTogether, LocalDate startDate, LocalDate endDate, String username) {
        this.scheduleId = scheduleId;
        this.name = name;
        this.isTogether = isTogether;
        this.startDate = startDate;
        this.endDate = endDate;
        this.username = username;
    }
}
