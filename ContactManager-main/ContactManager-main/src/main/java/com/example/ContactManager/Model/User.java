package com.example.ContactManager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "modified_at")
    private LocalDate modifiedAt;

}
