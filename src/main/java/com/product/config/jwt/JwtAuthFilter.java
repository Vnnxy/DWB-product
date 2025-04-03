package com.product.config.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.product.exception.AuthException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Carlos López Rodríguez.
 *         <p>
 *         Class that intercepts tokens
 *         </p>
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    /** The Util object */
    private final JwtUtil jwtUtil;

    /**
     * Constructor that asigns the given utility
     * 
     * @param jwtUtil the utility used
     */
    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Method that intercepts and verifies the given token
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {
            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                chain.doFilter(request, response);
                return;
            }

            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);

            if (!jwtUtil.isTokenValid(token, username)) {
                throw new AuthException(HttpStatus.UNAUTHORIZED, "Invalid JWT token");
            }

            // Check if token is expired
            if (jwtUtil.isTokenExpired(token)) {
                throw new AuthException(HttpStatus.UNAUTHORIZED, "JWT token has expired");
            }

            List<HashMap<String, String>> permisos = jwtUtil.extractPermisos(token);

            List<String> permisosList = permisos.stream().map(i -> i.get("authority")).toList();

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = User.withUsername(username)
                        .password("")
                        .authorities(permisosList.toArray(new String[0]))
                        .build();

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null,
                        userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            if (e.getMessage().contains("Invalid")) {
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token inválido");
            } else if (e.getMessage().contains("expired")) {
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "El token ha expirado");
            } else {
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Authentication failed");
            }
        }
    }
}
