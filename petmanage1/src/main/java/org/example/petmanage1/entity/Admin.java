package org.example.petmanage1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @Column(nullable = false, unique = true)
    private String adminName;
    @Column(nullable = false)
    private String adminPassword;
    private String adminPhoneNumber;
}
