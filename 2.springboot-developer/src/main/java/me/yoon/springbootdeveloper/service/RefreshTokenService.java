package me.yoon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.yoon.springbootdeveloper.domain.RefreshToken;
import me.yoon.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new IllegalArgumentException("Unexpected token"));
    }
}
