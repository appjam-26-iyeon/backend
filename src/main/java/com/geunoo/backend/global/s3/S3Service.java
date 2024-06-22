package com.geunoo.backend.global.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Service {

    private final AmazonS3 amazonS3;
    private final S3Properties s3Properties;

    public String uploadImage(MultipartFile image) {
        if (image.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String fileName = "younme/" + UUID.randomUUID() + image.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(image.getContentType());
        metadata.setContentLength(image.getSize());

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                s3Properties.getBucket(), fileName, image.getInputStream(), metadata
            );

            amazonS3.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amazonS3.getUrl(s3Properties.getBucket(), fileName).toString();
    }
}
