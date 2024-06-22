package com.geunoo.backend.domain.schedule.controller.dto.response;

import com.geunoo.backend.domain.schedule.repository.vo.QueryScheduleVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryMonthSchedulesResponse {

    private final List<QueryScheduleVO> schedules;
}
