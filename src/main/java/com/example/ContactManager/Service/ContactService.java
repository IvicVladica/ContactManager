package com.example.ContactManager.Service;

import com.example.ContactManager.Dto.ContactDto;
import com.example.ContactManager.Exceptions.NoSuchIdExistsException;
import com.example.ContactManager.Model.Contact;
import com.example.ContactManager.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ContactDto> getAllContacts() {
        List<Contact> allContacts = contactRepository.findAll();
        List<ContactDto> allContactsDto = new ArrayList<>();
        for (var contact : allContacts) {
            allContactsDto.add(this.contactToContactDto(contact));
        }
        return allContactsDto;
    }

    public void insertContact(ContactDto contactDto) {
        Contact contact = this.contactDtoToContact(contactDto);
        contactRepository.save(contact);
    }

    public void deleteContact(UUID id) {
        if (contactRepository.findByContactId(id) == null) {
            throw new NoSuchIdExistsException();
        }
        contactRepository.deleteByContactId(id);
    }

    public void updateContact(ContactDto contactDto, UUID id) { //+ ID  Entity not found
        if (contactRepository.findByContactId(id) == null) {
            throw new NoSuchIdExistsException();
        }
        Contact myContact = contactRepository.findByContactId(id);
        this.inputParametersToContactDto(contactDto, myContact);
        contactRepository.save(myContact);
    }

    private void inputParametersToContactDto (ContactDto contactDto, Contact myContact) {
        myContact.setFirstName(contactDto.getFirstName());
        myContact.setLastName(contactDto.getLastName());
        myContact.setAddress(contactDto.getAddress());
        myContact.setPhone(contactDto.getPhone());
    }

    private ContactDto contactToContactDto (Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setLastName(contact.getLastName());
        contactDto.setPhone(contact.getPhone());
        contactDto.setAddress(contact.getAddress());
        return contactDto;
    }

    private Contact contactDtoToContact (ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setPhone(contactDto.getPhone());
        contact.setAddress(contactDto.getAddress());
        contact.setTypeID(contactDto.getTypeId());
        return contact;
    }

}
