package com.geunoo.backend.domain.image.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateImageRequest {

    private List<String> imageUrls;
}
