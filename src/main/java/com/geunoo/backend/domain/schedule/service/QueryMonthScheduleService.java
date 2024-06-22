package com.geunoo.backend.domain.schedule.service;

import com.geunoo.backend.domain.schedule.controller.dto.response.QueryMonthSchedulesResponse;
import com.geunoo.backend.domain.schedule.repository.ScheduleQuerydslRepository;
import com.geunoo.backend.domain.schedule.repository.vo.QueryScheduleVO;
import com.geunoo.backend.domain.user.entity.User;
import com.geunoo.backend.domain.user.repository.UserRepository;
import com.geunoo.backend.global.error.exceptions.NotFoundException;
import com.gil.easyjwt.user.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryMonthScheduleService {

    private final ScheduleQuerydslRepository scheduleQuerydslRepository;
    private final UserRepository userRepository;
    private final CurrentUserService<User> currentUserService;

    public QueryMonthSchedulesResponse execute() {
        User user = userRepository.findById(currentUserService.getCurrentUser().getId())
            .orElseThrow(() -> new NotFoundException("User Not Found"));
        List<QueryScheduleVO> schedules = new ArrayList<>();
        schedules.addAll(scheduleQuerydslRepository.queryMonthSchedule(user.getId()));
        schedules.addAll(scheduleQuerydslRepository.queryMonthSchedule(user.getCouple().getId()));

        return new QueryMonthSchedulesResponse(schedules);
    }
}
