package org.example.petmanage1.service;

import org.example.petmanage1.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PetService {
    List<Pet> selectPetByOwnerId(Long ownerId);
    Pet selectPetByPetId(Long petId);
    Page<Pet> selectPetByOwnerId(Long ownerId, Pageable pageable);
    Pet petAdd(Pet pet);
    Pet petEdit(Long petId,Pet updatePet);
    void petDelete(Long petId);
}
