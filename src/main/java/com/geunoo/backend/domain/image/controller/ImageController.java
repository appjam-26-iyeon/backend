package com.geunoo.backend.domain.image.controller;

import com.geunoo.backend.domain.image.controller.dto.request.CreateImageRequest;
import com.geunoo.backend.domain.image.controller.dto.response.UrlResponse;
import com.geunoo.backend.domain.image.service.CreateImageService;
import com.geunoo.backend.domain.image.service.UploadImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final UploadImageService uploadImageService;
    private final CreateImageService createImageService;

    @PostMapping
    public UrlResponse uploadImage(@RequestPart MultipartFile image) {
        return uploadImageService.execute(image);
    }

    @PostMapping("/{schedule-id}")
    public void createImages(
        @PathVariable("schedule-id") Long scheduleId,
        @RequestBody @Valid CreateImageRequest request
    ) {
        createImageService.execute(request, scheduleId);
    }
}
