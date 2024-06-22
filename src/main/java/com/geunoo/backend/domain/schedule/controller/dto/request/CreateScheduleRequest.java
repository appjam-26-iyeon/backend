package com.geunoo.backend.domain.schedule.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateScheduleRequest {

    @NotNull
    private LocalDate startDate;

    @NotNull
    private String name;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Boolean isTogether;

    private List<String> imageUrls;
}
