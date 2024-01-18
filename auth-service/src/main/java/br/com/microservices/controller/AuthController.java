package br.com.microservices.controller;

import br.com.microservices.infra.security.UserAuthenticated;
import br.com.microservices.model.user.User;
import br.com.microservices.model.user.dto.Auth;
import br.com.microservices.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Auth request) {
        if (request.userName() == null || request.password() == null) {
            return "Credenciais inválidas";
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.userName(), request.password());
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            var userAuthenticated = (UserAuthenticated) authentication.getPrincipal();
            return tokenService.createToken(userAuthenticated);
        } catch (Exception e) {
            return "Falha na autenticação: " + e.getMessage();
        }
    }


}