package com.geunoo.backend.domain.couple.repository;

import com.geunoo.backend.domain.couple.entity.CoupleRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoupleRequestRepository extends JpaRepository<CoupleRequest, Long> {

    boolean existsByUserId(Long userId);

    Optional<CoupleRequest> findByCode(String code);
}
