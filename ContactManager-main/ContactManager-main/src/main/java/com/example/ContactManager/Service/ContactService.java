package com.example.ContactManager.Service;

import com.example.ContactManager.Model.Contact;
import com.example.ContactManager.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public void deleteContact(UUID id) {
        contactRepository.deleteByContactId(id);
    }

    public void updateContact(Contact contact) {
        Contact myContact = contactRepository.findByContactId(contact.getContactId());
        myContact.setContactId(contact.getContactId());
        myContact.setFirstName(contact.getFirstName());
        myContact.setLastName(contact.getLastName());
        myContact.setAddress(contact.getAddress());
        myContact.setPhone(contact.getPhone());
        myContact.setUserId(contact.getUserId());
        myContact.setTypeID(contact.getTypeID());
        contactRepository.save(myContact);
    }
}
