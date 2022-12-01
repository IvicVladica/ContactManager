package com.example.ContactManager.Service;

import com.example.ContactManager.Model.ContactType;
import com.example.ContactManager.Repository.ContactTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactTypeService {

    private ContactTypeRepository contactTypeRepository;

    @Autowired
    public ContactTypeService (ContactTypeRepository contactTypeRepository) {
        this.contactTypeRepository = contactTypeRepository;
    }

    public void insertContactType (ContactType contactType) {
        contactTypeRepository.save(contactType);
    }

    public void updateContactType (ContactType contactType) {
        ContactType myContactType = contactTypeRepository.findByTypeId(contactType.getTypeId());
        this.inputParametersToContactType(contactType, myContactType);
        contactTypeRepository.save(myContactType);
    }

    public void inputParametersToContactType (ContactType contactType, ContactType myContactType) {
        myContactType.setTypeId(contactType.getTypeId());
        myContactType.setContactType(contactType.getContactType());
        myContactType.setDescription(contactType.getDescription());
    }
}
