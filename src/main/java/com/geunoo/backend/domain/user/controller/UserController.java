package com.geunoo.backend.domain.user.controller;

import com.geunoo.backend.domain.user.controller.dto.request.LoginRequest;
import com.geunoo.backend.domain.user.controller.dto.request.SignUpRequest;
import com.geunoo.backend.domain.user.controller.dto.response.TokenResponse;
import com.geunoo.backend.domain.user.service.LoginService;
import com.geunoo.backend.domain.user.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }
}
