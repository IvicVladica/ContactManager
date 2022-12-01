package com.example.ContactManager.Repository;

import com.example.ContactManager.Model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactType, Integer> {
    ContactType findByTypeId(Integer id);
}
