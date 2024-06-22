package com.geunoo.backend.domain.user.service;

import com.geunoo.backend.domain.user.controller.dto.request.LoginRequest;
import com.geunoo.backend.domain.user.controller.dto.response.TokenResponse;
import com.geunoo.backend.domain.user.entity.User;
import com.geunoo.backend.domain.user.repository.UserRepository;
import com.geunoo.backend.global.error.exceptions.NotFoundException;
import com.geunoo.backend.global.error.exceptions.UnauthorizedException;
import com.gil.easyjwt.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public TokenResponse execute(LoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
            .orElseThrow(() -> new NotFoundException("User Not Found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid Password");
        }

        return new TokenResponse(
            jwtTokenProvider.generateAccessToken(user.getAccountId()),
            user.getCouple() != null
        );
    }
}
