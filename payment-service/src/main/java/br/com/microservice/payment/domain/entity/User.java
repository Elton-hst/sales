package br.com.microservice.payment.domain.entity;

import br.com.microservice.payment.persistence.entity.ProductEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductEntity> accounts = new HashSet<>();
    private String username;
    private String email;
    private String password;
    @CreationTimestamp
    private Instant creationTimestamp;
    @UpdateTimestamp
    private Instant updateTimestamp;

    public User() {
    }

    public User(UUID userId, String username, String email, String password, Set<ProductEntity> accounts) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
    }
}