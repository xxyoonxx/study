/*
package me.yoon.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.yoon.springbootdeveloper.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserDetailService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> {

                    HandlerMappingIntrospector introspector = new HandlerMappingIntrospector();

                    // Spring MVC 경로 처리
                    authorize.requestMatchers(new MvcRequestMatcher(introspector, "/login")).permitAll();
                    authorize.requestMatchers(new MvcRequestMatcher(introspector, "/signup")).permitAll();
                    authorize.requestMatchers(new MvcRequestMatcher(introspector, "/user")).permitAll();

                    // H2 Console 경로 처리
                    // 정적 리소스나 서블릿 처리
                    authorize.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll();

                    // 그 외의 요청은 인증 필요
                    authorize.anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/articles", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                )
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

}
*/
