package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.example.demo.models.usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class jwtUtil {
    private String secret = "springboot";

    public String extracNombre(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public Date extractExp(String token){
        return extractClaims(token,Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractall(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractall(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private boolean istokenExpired(String token){
        return extractExp(token).before(new Date());
    }

    public String generarToken(String nombre,String password){
        Map<String,Object> claims = new HashMap<>();
        claims.put("password", password);
        
        return createToken(claims,nombre);
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+100*60*60*10))
        .signWith(SignatureAlgorithm.HS384,"aasdasrf")
        .compact();
    }
}
