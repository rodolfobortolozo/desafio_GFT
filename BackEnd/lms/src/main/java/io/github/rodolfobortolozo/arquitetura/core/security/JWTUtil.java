package io.github.rodolfobortolozo.arquitetura.core.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt_secret}")
    private String secret;
    @Value("${security.jwt.expiration}")
    private Long expiration;

    public String generateToken(Usuario user) throws IllegalArgumentException, JWTCreationException {

        Date today = new Date();
        Date timeExpiration = new Date();
        timeExpiration.setTime(today.getTime() + expiration);

        return JWT.create()
                .withIssuer("LMS")
                .withSubject("User Details")
                .withIssuedAt(new Date())
                .withExpiresAt(timeExpiration)
                .withClaim("usuario", user.getUsuario())
                .withClaim("nome", user.getNome())
                .withClaim("role", user.getPermissao())
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("LMS")
                .withSubject("User Details")
                .build();
        DecodedJWT jwt = verifier.verify(token);

        return jwt.getClaim("usuario").asString();

    }
}