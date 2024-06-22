package com.geunoo.backend.domain.image.service;

import com.geunoo.backend.domain.image.controller.dto.response.UrlResponse;
import com.geunoo.backend.global.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadImageService {

    private final S3Service s3Service;

    public UrlResponse execute(MultipartFile image) {
        return new UrlResponse(s3Service.uploadImage(image));
    }
}
