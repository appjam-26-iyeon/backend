package com.geunoo.backend.domain.user.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotNull
    private String accountId;

    @NotNull
    private String password;
}
