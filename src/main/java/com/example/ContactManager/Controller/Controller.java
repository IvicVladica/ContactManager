package com.example.ContactManager.Controller;

import com.example.ContactManager.Dto.ContactDto;
import com.example.ContactManager.Dto.UserDto;
import com.example.ContactManager.Model.ContactType;
import com.example.ContactManager.Service.ContactService;
import com.example.ContactManager.Service.ContactTypeService;
import com.example.ContactManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    private final ContactService contactService;
    private final UserService userService;
    private final ContactTypeService contactTypeService;

    @Autowired
    public Controller (ContactService contactService, UserService userService, ContactTypeService contactTypeService) {
        this.contactService = contactService;
        this.userService = userService;
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("/api/contacts")
    public List<ContactDto> ListAll(@RequestHeader("Authorization") String token) {
        UUID id = userService.getUserIdFromToken(token);
        return contactService.getAllContacts(id);
    }

    @PostMapping("/api/contacts/create")
    public void InsertContact(@RequestBody @Valid ContactDto contactDto, @RequestHeader ("Authorization") String token) {
        UUID id = userService.getUserIdFromToken(token);
        contactService.insertContact(contactDto, id);
    }

    @DeleteMapping("/api/contacts/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void DeleteContact(@PathVariable UUID id) {
        contactService.deleteContact(id);
    }

    @PatchMapping("/api/contacts/patch/{id}")
    public void UpdateContact(@RequestBody ContactDto contactDto, @PathVariable UUID id) {
        contactService.updateContact(contactDto, id);
    }

    @PostMapping("api/users/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void insertUser(@RequestBody @Valid UserDto userDto) {
        userService.insertUser(userDto);
    }

    @PostMapping("api/users/login")
    public void logUser(@RequestBody UserDto userDto) {
    }

    @PatchMapping("api/users/patch/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable UUID id) {
        userService.updateUser(userDto, id);
    }

    @PostMapping("api/type/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void insertContactType(@RequestBody ContactType contactType) {
        contactTypeService.insertContactType(contactType);
    }

    @PatchMapping("api/type/patch")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateContactType(@RequestBody ContactType contactType) {
        contactTypeService.updateContactType(contactType);
    }
}
