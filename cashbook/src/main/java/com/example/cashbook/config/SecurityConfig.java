package com.example.cashbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 요청에 대한 접근 권한 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(
                                "/", "/member/join", "/member/joinProc", "/member/login", "/member/loginProc", "/script/**")
                        .permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated());

        // 로그인 설정
        http
                .formLogin((auth) -> auth
                        .loginPage("/member/login")
                        .usernameParameter("memberid")
                        .passwordParameter("memberpw")
                        .loginProcessingUrl("/member/loginProc")
                        .defaultSuccessUrl("/main", true)
                        .permitAll());

        // 로그아웃 설정
        http
                .logout((auth) -> auth
                        .logoutUrl("/member/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));

        // CSRF 비활성화 처리 부분
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
    
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
