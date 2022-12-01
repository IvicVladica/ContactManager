package com.example.ContactManager.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ContactDto {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private int typeId;
}
