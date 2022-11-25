package com.example.ContactManager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Contact")
public class Contact {
    @Id
    private int contact_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String address;
    private int user_id;
    private LocalDate created_at;
    private LocalDate modified_at;
}
