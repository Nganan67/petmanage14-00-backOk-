package org.example.petmanage1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;
    @Column(nullable = false)
    private String petName;
    private String petBreed;
    private int petAge;
    private String petGender;
    private String healthStatus;
    private String adoptionStatus;
    private String boardingStatus;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
