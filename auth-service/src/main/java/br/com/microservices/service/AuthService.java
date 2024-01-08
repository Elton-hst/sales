package br.com.microservices.service;

import br.com.microservices.dto.Auth;
import br.com.microservices.dto.TokenDTO;
import br.com.microservices.model.User;
import br.com.microservices.repository.UserRepository;
import br.com.microservices.service.exception.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    @Autowired
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUserName(username);
    }

//    private final JwtService jwtService;

//    public TokenDTO login(Auth request) {
//        User user = User.builder()
//                .username(request.userName())
//                .password(request.password())
//                .build();
//        validatePassword(request.password());
//        var token = jwtService.createToken(user);
//        return new TokenDTO(token);
//    }
//
//    private void validatePassword(String password) {
//        if (password.isBlank() || password.isEmpty()) {
//            throw new AuthException("Senha invalida");
//        }
//    }

}
