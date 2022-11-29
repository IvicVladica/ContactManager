package com.example.ContactManager.Controller;

import com.example.ContactManager.Model.Contact;
import com.example.ContactManager.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private ContactService contactService;

    @Autowired
    public Controller (ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/api/contacts")
    public List<Contact> ListAll() {
        return contactService.getAllContacts();
    }

    @PostMapping("/api/contacts/create")
    public void InsertContact(@RequestBody Contact contact) {
        contactService.insertContact(contact);
    }

    @DeleteMapping("/api/contacts/delete")
    public void DeleteContact(@RequestBody int id) {
        contactService.deleteContact(id);
    }

}
