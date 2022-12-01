package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserId(UUID id);
}

