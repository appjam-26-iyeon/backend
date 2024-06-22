package com.geunoo.backend.domain.user.service;

import com.geunoo.backend.domain.user.controller.dto.request.SignUpRequest;
import com.geunoo.backend.domain.user.entity.User;
import com.geunoo.backend.domain.user.repository.UserRepository;
import com.geunoo.backend.global.error.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw new ConflictException("User Already Exists");
        }

        userRepository.save(
            User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .profileImage(request.getProfileImage())
                .birthday(request.getBirthday())
                .build()
        );
    }
}
