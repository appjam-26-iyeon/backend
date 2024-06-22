package com.geunoo.backend.domain.couple.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCoupleRequest {
    @NotNull
    private String code;
}
