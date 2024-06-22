package com.geunoo.backend.domain.couple.service;

import com.geunoo.backend.domain.couple.controller.dto.response.CreateCoupleRequestResponse;
import com.geunoo.backend.domain.couple.entity.CoupleRequest;
import com.geunoo.backend.domain.couple.repository.CoupleRequestRepository;
import com.geunoo.backend.domain.user.entity.User;
import com.geunoo.backend.global.error.exceptions.ConflictException;
import com.gil.easyjwt.user.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCoupleRequestService {

    private final CoupleRequestRepository coupleRequestRepository;
    private final CurrentUserService<User> currentUserService;

    @Transactional
    public CreateCoupleRequestResponse execute() {
        User user = currentUserService.getCurrentUser();
        String code = RandomStringUtils.randomNumeric(6);

        if (coupleRequestRepository.existsByUserId(user.getId())) {
            throw new ConflictException("CoupleRequest Already Exists");
        }

        coupleRequestRepository.save(
            CoupleRequest.builder()
                .user(user)
                .code(code)
                .build()
        );

        return new CreateCoupleRequestResponse(code);
    }
}
