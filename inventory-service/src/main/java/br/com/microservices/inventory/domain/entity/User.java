package br.com.microservices.inventory.domain.entity;

import br.com.microservices.inventory.persistence.entity.ProductEntity;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Set<ProductEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<ProductEntity> accounts) {
        this.accounts = accounts;
    }
}