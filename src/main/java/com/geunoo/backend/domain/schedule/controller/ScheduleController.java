package com.geunoo.backend.domain.schedule.controller;

import com.geunoo.backend.domain.schedule.controller.dto.request.CreateScheduleRequest;
import com.geunoo.backend.domain.schedule.controller.dto.response.QueryMonthSchedulesResponse;
import com.geunoo.backend.domain.schedule.service.CreateScheduleService;
import com.geunoo.backend.domain.schedule.service.QueryMonthScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/schedule")
@RestController
public class ScheduleController {

    private final CreateScheduleService createScheduleService;
    private final QueryMonthScheduleService queryMonthScheduleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createSchedule(@RequestBody @Valid CreateScheduleRequest request) {
        createScheduleService.execute(request);
    }

    @GetMapping("/month")
    public QueryMonthSchedulesResponse queryMonthSchedules() {
        return queryMonthScheduleService.execute();
    }
}
