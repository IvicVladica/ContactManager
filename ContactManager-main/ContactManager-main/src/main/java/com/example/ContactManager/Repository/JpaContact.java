package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaContact extends JpaRepository<Contact, Integer>{
}
