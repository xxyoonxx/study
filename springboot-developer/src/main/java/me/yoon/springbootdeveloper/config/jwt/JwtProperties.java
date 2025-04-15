package me.yoon.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") // 프로퍼티 값을 가져와서 자바 클래스에 매핑하는 어노테이션
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
