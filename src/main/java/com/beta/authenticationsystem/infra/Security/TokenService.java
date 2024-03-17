package com.beta.authenticationsystem.infra.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.beta.authenticationsystem.Models.RegistrosUsuarios.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken (Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            System.out.println("Este es el email del usuario: "+usuario.getEmail());
            System.out.println("Este es la contraseña del usuario: "+usuario.getContraseña());
            return JWT.create()
                    .withIssuer("Apple_Bank")
                    .withSubject(usuario.getEmail())
                    .withClaim("Contrasena",usuario.getContraseña())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }


    public String getSubject(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacío");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("Apple_Bank")
                    .build()
                    .verify(token);
            return verifier.getSubject();
        } catch (JWTVerificationException exception) {
            //return ResponseEntity.status(401).body("Error al verificar o decodificar el token").toString();
            throw new RuntimeException("Error al verificar o decodificar el token", exception);
        }
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }



}
