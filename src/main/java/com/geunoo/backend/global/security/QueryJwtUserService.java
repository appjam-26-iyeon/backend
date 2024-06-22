package com.geunoo.backend.global.security;

import com.geunoo.backend.domain.user.repository.UserRepository;
import com.gil.easyjwt.user.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class QueryJwtUserService implements com.gil.easyjwt.user.QueryJwtUserService {

    private final UserRepository userRepository;

    @Override
    public Optional<JwtUser> execute(String accountId) {
        return userRepository.findByAccountId(accountId)
                .map(JwtUser.class::cast);
    }
}
