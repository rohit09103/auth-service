package com.localhost.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {

    private String accessTokenSecretKey = null;
    private String refreshTokenSecretKey = null;
    private long accessTokenValidityInMilliseconds = 900000; // 15 minutes
    private long refreshTokenValidityInMilliseconds = 7200000; // 2 hour

    // Generate Access Token
    public String generateAccessToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, getAccessTokenSecretKey(), accessTokenValidityInMilliseconds);
    }

    // Generate Refresh Token
    public String generateRefreshToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, getRefreshTokenSecretKey(), refreshTokenValidityInMilliseconds);
    }

    private String createToken(Map<String, Object> claims, String subject, String secret, long validity) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Validate Access Token
    public boolean validateAccessToken(String token, String username) {
        final String extractedUsername = extractUsername(token, getAccessTokenSecretKey());
        return (extractedUsername.equals(username) && !isTokenExpired(token, getAccessTokenSecretKey()));
    }

    // Validate Refresh Token
    public boolean validateRefreshToken(String token, String username) {
        final String extractedUsername = extractUsername(token, getRefreshTokenSecretKey());
        return (extractedUsername.equals(username) && !isTokenExpired(token, getRefreshTokenSecretKey()));
    }

    private boolean isTokenExpired(String token, String secret) {
        return extractExpiration(token, secret).before(new Date());
    }

    private Date extractExpiration(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
    }

    public String extractUsername(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    private String secureJwtKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
    
    private String getAccessTokenSecretKey() {
    	if (null == accessTokenSecretKey || accessTokenSecretKey.isBlank()) {
    		synchronized (this) {
    			if (null == accessTokenSecretKey) {
    				accessTokenSecretKey = secureJwtKey();
    				log.debug("AccessToken secret key : [{}]", accessTokenSecretKey);
    			}
			}
    	}
    	return accessTokenSecretKey;
    }
    
    private String getRefreshTokenSecretKey() {
    	if (null == refreshTokenSecretKey || refreshTokenSecretKey.isBlank()) {
    		synchronized (this) {
    			if (null == refreshTokenSecretKey) {
    				refreshTokenSecretKey = secureJwtKey();
    				log.debug("RefreshToken secret key : [{}]", refreshTokenSecretKey);
    			}
			}
    	}
    	return refreshTokenSecretKey;
    }
}

