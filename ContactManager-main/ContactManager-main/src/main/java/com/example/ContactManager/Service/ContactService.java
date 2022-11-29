package com.example.ContactManager.Service;

import com.example.ContactManager.Model.Contact;
import com.example.ContactManager.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    //metoda koja od DTO pravi entitesku klasu i puni svim field-ovima

    @Autowired
    public ContactService (ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void insertContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
