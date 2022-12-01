package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID>{

    @Transactional
    void deleteByContactId(UUID id);
    Contact findByContactId(UUID id);
}





