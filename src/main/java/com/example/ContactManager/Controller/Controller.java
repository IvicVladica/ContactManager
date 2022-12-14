package com.example.ContactManager.Controller;

import com.example.ContactManager.Dto.ContactDto;
import com.example.ContactManager.Dto.UserDto;
import com.example.ContactManager.Model.Contact;

import com.example.ContactManager.Model.ContactType;
import com.example.ContactManager.Model.User;
import com.example.ContactManager.Security.JWTAuthenticationFilter;
import com.example.ContactManager.Service.ContactService;
import com.example.ContactManager.Service.ContactTypeService;
import com.example.ContactManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    private ContactService contactService;
    private UserService userService;
    private ContactTypeService contactTypeService;

    @Autowired
    public Controller (ContactService contactService, UserService userService, ContactTypeService contactTypeService) {
        this.contactService = contactService;
        this.userService = userService;
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("/api/contacts")
    public List<ContactDto> ListAll() {
        return contactService.getAllContacts();
    }

    @PostMapping("/api/contacts/create")
    public void InsertContact(@RequestBody ContactDto contactDto) {
        contactService.insertContact(contactDto);
    }

    @DeleteMapping("/api/contacts/delete/{id}")
    public void DeleteContact(@PathVariable UUID id) {
        contactService.deleteContact(id);
    }

    @PatchMapping("/api/contacts/patch/{id}")
    public void UpdateContact(@RequestBody ContactDto contactDto, @PathVariable UUID id) {
        contactService.updateContact(contactDto, id);
    }

    @PostMapping("api/users/create")
    public void insertUser(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
    }

//    @PostMapping("api/users/login")
//    public void logUser(@RequestBody UserDto userDto) {
//    };

    @PatchMapping("api/users/patch/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable UUID id) {
        userService.updateUser(userDto, id);
    }

    @PostMapping("api/type/create")
    public void insertContactType(@RequestBody ContactType contactType) {
        contactTypeService.insertContactType(contactType);
    }

    @PatchMapping("api/type/patch")
    public void updateContactType(@RequestBody ContactType contactType) {
        contactTypeService.updateContactType(contactType);
    }
}
