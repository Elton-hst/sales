package br.com.microservices.service;

import com.auth0.jwt.JWT;
import br.com.microservices.model.User;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    public String createToken(User user) {
        return JWT.create()
                .withIssuer("user")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(getExpirationAt())
                .sign(Algorithm.HMAC256("secreta"));
    }

    private Date getExpirationAt() {
        Integer ONE_DAY_IN_HOURS = 24;
        return Date.from(
                LocalDateTime.now()
                        .plusHours(ONE_DAY_IN_HOURS)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

}
