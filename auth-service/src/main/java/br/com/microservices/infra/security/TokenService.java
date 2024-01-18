package br.com.microservices.infra.security;

import com.auth0.jwt.JWT;
import br.com.microservices.model.user.User;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {

    public String createToken(UserAuthenticated userAuthenticated) {
        var user = User.builder()
                .userName(userAuthenticated.getUsername())
                .build();

        return JWT.create()
                .withIssuer("products")
                .withSubject(user.getUserName())
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

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("products")
                .build().verify(token).getSubject();
    }
}
