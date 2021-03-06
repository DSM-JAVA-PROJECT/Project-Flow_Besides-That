package com.asdf.JavaProject.config;

import com.asdf.JavaProject.config.user.CustomUserDetailsService;
import com.asdf.JavaProject.dto.TokenContent;
import com.asdf.JavaProject.entity.user.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtToken {
    @Value("${auth.jwt.secret}")
    private String secretKey;

//    private static final String HEADER = "Authorization";
//
//    private static final String PREFIX = "Bearer";

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public String createToken(User user) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("server")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(10).toMillis()))
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

    }

    public String createRefreshToken(User user) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("server")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofDays(14).toMillis()))
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public TokenContent decodeToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

        TokenContent tokenContent = new TokenContent(String.valueOf(claims.getBody().get("id")), String.valueOf(claims.getBody().get("email")));

        return tokenContent;
    }
}
