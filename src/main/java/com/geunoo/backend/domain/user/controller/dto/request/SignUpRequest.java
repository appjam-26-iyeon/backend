package com.geunoo.backend.domain.user.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotNull
    private String accountId;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String profileImage;

    @NotNull
    private Date birthday;
}
