package com.geunoo.backend.domain.couple.controller;

import com.geunoo.backend.domain.couple.controller.dto.request.CreateCoupleRequest;
import com.geunoo.backend.domain.couple.controller.dto.response.CreateCoupleRequestResponse;
import com.geunoo.backend.domain.couple.controller.dto.response.CreateCoupleResponse;
import com.geunoo.backend.domain.couple.service.CreateCoupleRequestService;
import com.geunoo.backend.domain.couple.service.CreateCoupleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/couple")
@RestController
public class CoupleController {

    private final CreateCoupleRequestService createCoupleRequestService;
    private final CreateCoupleService createCoupleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/request")
    public CreateCoupleRequestResponse createCoupleRequest() {
        return createCoupleRequestService.execute();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateCoupleResponse createCouple(@RequestBody @Valid CreateCoupleRequest request) {
        return createCoupleService.execute(request);
    }
}
