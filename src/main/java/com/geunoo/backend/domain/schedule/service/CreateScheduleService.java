package com.geunoo.backend.domain.schedule.service;

import com.geunoo.backend.domain.image.entity.Image;
import com.geunoo.backend.domain.image.repository.ImageRepository;
import com.geunoo.backend.domain.schedule.controller.dto.request.CreateScheduleRequest;
import com.geunoo.backend.domain.schedule.entity.Schedule;
import com.geunoo.backend.domain.schedule.repository.ScheduleRepository;
import com.geunoo.backend.domain.user.entity.User;
import com.gil.easyjwt.user.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ImageRepository imageRepository;
    private final CurrentUserService<User> userCurrentUserService;

    @Transactional
    public void execute(CreateScheduleRequest request) {
        User user = userCurrentUserService.getCurrentUser();

        Schedule schedule = scheduleRepository.save(
            Schedule.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .name(request.getName())
                .isTogether(request.getIsTogether())
                .user(user)
                .build()
        );

        imageRepository.saveAll(
            request.getImageUrls().stream()
                .map(image -> new Image(image, schedule))
                .toList()
        );
    }
}
