package com.foodorder.backend.configration.security;

import com.foodorder.backend.domain.handlers.CustomAccessDeniedHandler;
import com.foodorder.backend.domain.handlers.CustomAuthenticationEntryPoint;
import com.foodorder.backend.domain.services.security.SysUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final SysUserDetailsService sysUserDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Value("${online-food-order.security.paths.admin}")
    private String adminPaths;

    @Value("${online-food-order.security.paths.endpoints.public}")
    private String publicPaths;

    @Value("${online-food-order.security.paths.actuator.public}")
    private String actuatorPublicPaths;

    @Value("${online-food-order.security.paths.actuator.private}")
    private String actuatorPrivatePaths;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(sysUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
                )
                .authorizeHttpRequests(registry -> {
                    registry
                            .requestMatchers(publicPaths.split(",")).permitAll()

                            .requestMatchers(actuatorPublicPaths.split(",")).permitAll()
                            .requestMatchers(actuatorPrivatePaths.split(",")).hasRole("ADMIN")

                            .requestMatchers(adminPaths.split(",")).hasRole("ADMIN")

                            .anyRequest().authenticated();
                })
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }



}
