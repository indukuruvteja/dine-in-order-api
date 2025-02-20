package com.example.dio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String email;
    private String password;
    private LocalDate createAt;
    private LocalDate lastModified;


}
