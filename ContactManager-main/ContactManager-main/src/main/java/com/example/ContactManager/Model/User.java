package com.example.ContactManager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_table")
public class User {
    @Id
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String user_type;

}
