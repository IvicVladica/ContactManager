package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID>{

    @Transactional
    void deleteByContactId(UUID id);
    Contact findByContactId(UUID id);
}





