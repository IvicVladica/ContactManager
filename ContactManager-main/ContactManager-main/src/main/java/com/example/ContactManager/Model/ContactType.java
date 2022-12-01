package com.example.ContactManager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "contacttype")
public class ContactType {

    @Id
    @Column(name = "type_id")
    int typeId;

    @Column(name = "contact_type")
    String contactType;

    @Column(name = "description")
    String description;
}
