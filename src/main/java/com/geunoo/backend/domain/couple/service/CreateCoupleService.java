package com.geunoo.backend.domain.couple.service;

import com.geunoo.backend.domain.couple.controller.dto.request.CreateCoupleRequest;
import com.geunoo.backend.domain.couple.controller.dto.response.CreateCoupleResponse;
import com.geunoo.backend.domain.couple.entity.CoupleRequest;
import com.geunoo.backend.domain.couple.repository.CoupleRequestRepository;
import com.geunoo.backend.domain.user.entity.User;
import com.geunoo.backend.domain.user.repository.UserRepository;
import com.geunoo.backend.global.error.exceptions.ConflictException;
import com.geunoo.backend.global.error.exceptions.NotFoundException;
import com.gil.easyjwt.user.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCoupleService {

    private final CoupleRequestRepository coupleRequestRepository;
    private final CurrentUserService<User> currentUserService;
    private final UserRepository userRepository;

    @Transactional
    public CreateCoupleResponse execute(CreateCoupleRequest request) {
        User currentUser = userRepository.findById(currentUserService.getCurrentUser().getId())
            .orElseThrow(() -> new NotFoundException("User Not Found"));
        CoupleRequest coupleRequest = coupleRequestRepository.findByCode(request.getCode())
            .orElseThrow(() -> new NotFoundException("CoupleRequest Not Found"));
        User coupleUser = coupleRequest.getUser();

        if (coupleRequest.getUser().equals(currentUser)) {
            throw new ConflictException("Same User");
        }

        currentUser.updateCouple(coupleUser);
        coupleUser.updateCouple(currentUser);

        coupleRequestRepository.delete(coupleRequest);

        return new CreateCoupleResponse(coupleUser.getName());
    }
}
