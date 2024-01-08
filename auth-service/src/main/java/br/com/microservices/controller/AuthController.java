package br.com.microservices.controller;

import br.com.microservices.model.User;
import br.com.microservices.dto.Auth;
import br.com.microservices.dto.TokenDTO;
import br.com.microservices.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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
            var usuario = (User) authentication.getPrincipal();
            return jwtService.createToken(usuario);
        } catch (Exception e) {
            return "Falha na autenticação: " + e.getMessage();
        }
    }


}