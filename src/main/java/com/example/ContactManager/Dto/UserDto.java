package com.example.ContactManager.Dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class UserDto {

    @Length(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @Email
    private String email;

    @Length(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Length(min = 3, message = "UserType must be at least 3 characters long")
    private String userType;
}
