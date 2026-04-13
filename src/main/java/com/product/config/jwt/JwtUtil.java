package com.product.config.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Carlos López Rodríguez.
 *         <p>
 *         Class with utility
 *         </p>
 */
@Component
public class JwtUtil {
    /** The secret key used for the jwt */
    private final String SECRET_KEY = "ContrasenaSuperSeguraContrasenaSuperSeguraContrasenaSuperSeguraContrasenaSuperSeguraContrasenaSuperSegura";

    /**
     * Method that extracts the claims in a token
     * 
     * @param token The token
     * @return Claims
     */
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Extracts the username in a token
     * 
     * @param token The token
     * @return String with the username
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the authorities in a token
     * 
     * @param token the token
     * @return The list with the authorities
     */
    public List<HashMap<String, String>> extractPermisos(String token) {
        return extractClaims(token).get("roles", List.class);
    }

    /**
     * MEthod that verifies wheter a token is valid
     * 
     * @param token    The token
     * @param username The username
     * @return true if is valid, false in other case.
     */
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    /**
     * MEthod that berifies whether a token is expires
     * 
     * @param token The token
     * @return true if the token is expires, false in other case
     */
    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    /**
     * Method that extracts claims in a token
     * 
     * @param token          The token
     * @param claimsResolver The claim resolver
     * @return THe claim
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractClaims(token));
    }
}
