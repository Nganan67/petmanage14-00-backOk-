package org.example.petmanage1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String userPassword;
    private String userPhoneNumber;
}
