package com.sandari.rain.intrastructure.entities;

import java.sql.Timestamp;
import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;

import com.sandari.rain.domain.entities.DomainUser;
import com.sandari.rain.domain.enums.DomainUserRole;
import com.sandari.rain.domain.interfaces.IDomainUser;

@Entity(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false, length = 255)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_role", nullable = false, length = 255)
    private DomainUserRole userRole;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    // @PrePersist
    // protected void onCreate() {
    //     this.createdAt = Timestamp.from(Instant.now());
    //     this.updatedAt = Timestamp.from(Instant.now());
    // }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public UserEntity(Long id, String username, String password, DomainUserRole role, Instant createdAt, Instant updatedAt) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.userRole = role;
        this.createdAt = Timestamp.from(createdAt);
        this.updatedAt = Timestamp.from(updatedAt);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DomainUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(DomainUserRole userRole) {
        this.userRole = userRole;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static UserEntity fromDomain(IDomainUser user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getUserRole(), user.getCreatedAt(), user.getUpdatedAt());
    }

    public IDomainUser toDomain() {
        return new DomainUser(this.userId, this.username, this.password, this.userRole, this.createdAt.toInstant(), this.updatedAt.toInstant());
    }

    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Profile profile;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Note> notes;
}
