package com.geunoo.backend.domain.image.repository;

import com.geunoo.backend.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
