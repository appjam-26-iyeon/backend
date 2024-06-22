package com.geunoo.backend.domain.image.service;

import com.geunoo.backend.domain.image.controller.dto.request.CreateImageRequest;
import com.geunoo.backend.domain.image.entity.Image;
import com.geunoo.backend.domain.image.repository.ImageRepository;
import com.geunoo.backend.domain.schedule.entity.Schedule;
import com.geunoo.backend.domain.schedule.repository.ScheduleRepository;
import com.geunoo.backend.global.error.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateImageService {

    private final ImageRepository imageRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void execute(CreateImageRequest request, Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(() -> new NotFoundException("Schedule Not Found"));

        imageRepository.saveAll(
            request.getImageUrls().stream()
                .map(image -> new Image(image, schedule))
                .toList()
        );
    }
}
