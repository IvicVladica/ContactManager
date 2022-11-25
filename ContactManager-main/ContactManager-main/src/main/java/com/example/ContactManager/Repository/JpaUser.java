package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.Contact;
import com.example.ContactManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUser extends JpaRepository<User, Integer> {
}

