package com.product.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.config.jwt.JwtAuthFilter;

/**
 * @author Carlos López Rodríguez.
 *         <p>
 *         Class that defines the required authorities in every endpoint
 *         </p>
 */
@Configuration
public class SecurityConfig {

        /** The filter */
        @Autowired
        private JwtAuthFilter jwtFilter;

        /**
         * Defines a security fileter chain as a java bean
         * 
         * @param http       The security http
         * @param corsConfig The CORS Configuration object used
         * @return SecurityFilterChain as a java bean
         * @throws Exception
         */
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfig corsConfig) throws Exception {

                http.csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(
                                                auth -> auth
                                                                .requestMatchers("/error", "/swagger-ui/**",
                                                                                "/v3/api-docs/**", "/actuator/info",
                                                                                "/actuator/health")
                                                                .permitAll()
                                                                // category
                                                                .requestMatchers(HttpMethod.GET, "/category/active")
                                                                .hasAnyAuthority("ADMIN", "CUSTOMER")
                                                                .requestMatchers("/category/**").hasAuthority("ADMIN")
                                                                // product
                                                                .requestMatchers(HttpMethod.GET, "/product/*")
                                                                .hasAnyAuthority("ADMIN", "CUSTOMER")
                                                                .requestMatchers("/product/**").hasAuthority("ADMIN")
                                                                // customer-images
                                                                .requestMatchers("/product-image/**")
                                                                .hasAnyAuthority("ADMIN", "CUSTOMER")

                                )

                                .cors(cors -> cors.configurationSource(corsConfig))
                                .httpBasic(Customizer.withDefaults())
                                .formLogin(form -> form.disable())
                                .sessionManagement(
                                                httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}
