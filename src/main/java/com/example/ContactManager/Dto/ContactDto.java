package com.example.ContactManager.Dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ContactDto {

    @NotBlank(message = "Invalid name: empty name")
    @NotNull(message = "Invalid name: Name is null")
    private String firstName;

    @NotBlank(message = "Invalid name: empty name")
    @NotNull(message = "Invalid name: Name is null")
    private String lastName;


    private String phone;


    private String address;


    private int typeId;
}
