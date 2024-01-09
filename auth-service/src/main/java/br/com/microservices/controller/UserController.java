package br.com.microservices.controller;

import br.com.microservices.model.user.User;
import br.com.microservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/home")
public class UserController {

    private final UserRepository repository;

    @PostMapping("/criar")
    public ResponseEntity<User> createUser(@RequestBody User user){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User newUser = User.builder()
                .userName(user.getUserName())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();
        var created = repository.save(newUser);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/buscar/{userName}")
    public ResponseEntity<User> findUser(@PathVariable String userName) {
        var find = repository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username"));
        return ResponseEntity.ok(find);
    }

    @GetMapping
    public String test() {
        return "funciona";
    }

}
